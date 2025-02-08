package com.relatosdepapel.ms_book_payment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;

    @NotBlank(message = "El autor no puede estar vacio")
    private String author;

    @PastOrPresent(message = "La fecha de publicación no puede ser futura")
    private LocalDate publicationDate;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String category;

    @Pattern(regexp = "\\d{13}", message = "El ISBN debe tener 13 dígitos")
    private String isbn;

    @Min(value = 0, message = "La calificación no puede ser negativa")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Double rating;

    private Boolean visible;

    public Book() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}