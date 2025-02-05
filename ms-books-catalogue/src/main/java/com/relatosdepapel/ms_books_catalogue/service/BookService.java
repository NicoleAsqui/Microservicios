package com.tienda.service;

import com.tienda.model.Book;
import com.tienda.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Obtener todos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Crear un nuevo libro
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Actualizar un libro existente
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

    // Eliminar un libro
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Búsqueda avanzada
    public List<Book> searchBooks(String title, String author, String category, String isbn, Double rating, Boolean visible) {
        return bookRepository.searchBooks(title, author, category, isbn, rating, visible);
    }
}