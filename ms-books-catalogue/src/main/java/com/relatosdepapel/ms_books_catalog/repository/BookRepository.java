package com.relatosdepapel.ms_books_catalog.repository;

import com.relatosdepapel.ms_books_catalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByCategoryContainingIgnoreCase(String category);

    List<Book> findByIsbn(String isbn);

    List<Book> findByRatingGreaterThanEqual(Double rating);

    List<Book> findByVisible(Boolean visible);

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