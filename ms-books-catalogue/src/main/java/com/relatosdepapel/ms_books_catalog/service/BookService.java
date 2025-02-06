package com.relatosdepapel.ms_books_catalog.service;

import com.relatosdepapel.ms_books_catalog.model.Book;
import com.relatosdepapel.ms_books_catalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setCategory(bookDetails.getCategory());
        book.setIsbn(bookDetails.getIsbn());
        book.setRating(bookDetails.getRating());
        book.setVisible(bookDetails.getVisible());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title, String author, String category, String isbn, Double rating, Boolean visible) {
        return bookRepository.searchBooks(title, author, category, isbn, rating, visible);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> updateBookPartial(Long id, Book bookDetails) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();

            if (bookDetails.getTitle() != null) {
                book.setTitle(bookDetails.getTitle());
            }
            if (bookDetails.getAuthor() != null) {
                book.setAuthor(bookDetails.getAuthor());
            }
            if (bookDetails.getPublicationDate() != null) {
                book.setPublicationDate(bookDetails.getPublicationDate());
            }
            if (bookDetails.getCategory() != null) {
                book.setCategory(bookDetails.getCategory());
            }
            if (bookDetails.getIsbn() != null) {
                book.setIsbn(bookDetails.getIsbn());
            }
            if (bookDetails.getRating() != null) {
                book.setRating(bookDetails.getRating());
            }
            if (bookDetails.getVisible() != null) {
                book.setVisible(bookDetails.getVisible());
            }

            return Optional.of(bookRepository.save(book));
        }
        return Optional.empty();
    }
}