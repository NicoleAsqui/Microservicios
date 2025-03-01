package com.relatosdepapel.ms_books_catalog.controller;

import com.relatosdepapel.ms_books_catalog.model.Book;
import com.relatosdepapel.ms_books_catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String query) {
        List<Book> books = bookService.searchBooks(query);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/suggest")
    public ResponseEntity<List<String>> suggestTitles(@RequestParam String prefix) {
        List<String> suggestions = bookService.suggestTitles(prefix);
        return ResponseEntity.ok(suggestions);
    }

    @GetMapping("/facets")
    public ResponseEntity<Map<String, Long>> getFacets() {
        Map<String, Long> facets = bookService.getFacets();
        return ResponseEntity.ok(facets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id) {
        Optional<Book> book = bookService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> findBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.findBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.findBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> findBooksByCategory(@PathVariable String category) {
        List<Book> books = bookService.findBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/generate-test-data")
    public ResponseEntity<String> generateTestData() {
        bookService.generateTestData();
        return ResponseEntity.ok("Datos de prueba generados exitosamente");
    }
}
