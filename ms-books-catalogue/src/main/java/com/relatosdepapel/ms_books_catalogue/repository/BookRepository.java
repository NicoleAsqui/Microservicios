package com.tienda.repository;

import com.tienda.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Búsqueda por título (ignorando mayúsculas/minúsculas)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Búsqueda por autor (ignorando mayúsculas/minúsculas)
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Búsqueda por categoría (ignorando mayúsculas/minúsculas)
    List<Book> findByCategoryContainingIgnoreCase(String category);

    // Búsqueda por ISBN
    List<Book> findByIsbn(String isbn);

    // Búsqueda por valoración mayor o igual a un valor
    List<Book> findByRatingGreaterThanEqual(Double rating);

    // Búsqueda por visibilidad
    List<Book> findByVisible(Boolean visible);

    // Búsqueda combinada (título, autor, categoría, ISBN, rating, visible)
    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
            "(:category IS NULL OR LOWER(b.category) LIKE LOWER(CONCAT('%', :category, '%'))) AND " +
            "(:isbn IS NULL OR b.isbn = :isbn) AND " +
            "(:rating IS NULL OR b.rating >= :rating) AND " +
            "(:visible IS NULL OR b.visible = :visible)")
    List<Book> searchBooks(
            @Param("title") String title,
            @Param("author") String author,
            @Param("category") String category,
            @Param("isbn") String isbn,
            @Param("rating") Double rating,
            @Param("visible") Boolean visible);
}