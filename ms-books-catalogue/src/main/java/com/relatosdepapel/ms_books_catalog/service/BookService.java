package com.relatosdepapel.ms_books_catalog.service;

import com.relatosdepapel.ms_books_catalog.model.Book;
import com.relatosdepapel.ms_books_catalog.repository.BookRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookService {

    private final BookRepository bookRepository;
    
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Guarda un libro en Elasticsearch.
     *
     * @param book El libro a guardar.
     * @return El libro guardado.
     */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Busca un libro por su ID.
     *
     * @param id El ID del libro.
     * @return El libro encontrado, o un Optional vacío si no existe.
     */
    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    /**
     * Busca libros por título.
     *
     * @param title El título del libro.
     * @return Una lista de libros que coinciden con el título.
     */
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    /**
     * Busca libros por autor.
     *
     * @param author El autor del libro.
     * @return Una lista de libros que coinciden con el autor.
     */
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * Busca libros por categoría.
     *
     * @param category La categoría del libro.
     * @return Una lista de libros que coinciden con la categoría.
     */
    public List<Book> findBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    /**
     * Elimina un libro por su ID.
     *
     * @param id El ID del libro a eliminar.
     */
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    /**
     * Obtiene todos los libros.
     *
     * @return Una lista de todos los libros.
     */
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public void generateTestData() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Book book = new Book();
            book.setId(String.valueOf(i));
            book.setTitle("Libro de prueba " + i);
            book.setAuthor("Autor " + i);
            book.setCategory("Categoría " + (i % 10)); // 10 categorías diferentes
            books.add(book);
            bookRepository.save(book);
        }
    }

    public List<Book> searchBooks(String query) {
        // Construye la consulta de búsqueda
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(query, "title", "author", "category"))
                .build();

        // Ejecuta la consulta
        SearchHits<Book> searchHits = elasticsearchRestTemplate.search(searchQuery, Book.class, IndexCoordinates.of("books"));

        // Convierte los resultados en una lista de libros
        return searchHits.stream()
                .map(hit -> hit.getContent())  // Obtiene el contenido de cada resultado
                .collect(Collectors.toList());
    }

    public List<String> suggestTitles(String prefix) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.prefixQuery("title", prefix))
                .build();
        return elasticsearchRestTemplate.search(searchQuery, Book.class)
                .stream()
                .map(hit -> hit.getContent().getTitle())
                .collect(Collectors.toList());
    }

    public Map<String, Long> getFacets() {
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_category").field("category");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .addAggregation(aggregation)
                .build();

        SearchHits<Book> searchHits = elasticsearchRestTemplate.search(searchQuery, Book.class);
        Terms terms = searchHits.getAggregations().get("by_category");

        return terms.getBuckets().stream()
                .collect(Collectors.toMap(
                        Terms.Bucket::getKeyAsString,
                        Terms.Bucket::getDocCount
                ));
    }
}