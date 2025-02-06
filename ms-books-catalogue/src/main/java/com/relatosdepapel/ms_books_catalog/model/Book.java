package com.relatosdepapel.ms_books_catalog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
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

    public Book() {

    }
}