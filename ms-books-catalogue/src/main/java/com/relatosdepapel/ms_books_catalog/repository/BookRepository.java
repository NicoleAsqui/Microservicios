package com.relatosdepapel.ms_books_catalog.repository;

import com.relatosdepapel.ms_books_catalog.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByTitle(String title);  // Búsqueda por título
    List<Book> findByAuthor(String author);  // Búsqueda por autor
    List<Book> findByCategory(String category);  // Búsqueda por categoría

    Book save(Book book);

    Optional<Book> findById(String id);

    void deleteById(String id);

    void delete(Book book);

    List<Book> findAll();
}