package com.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;           // Título del libro
    private String author;          // Autor del libro
    private String publicationDate; // Fecha de publicación
    private String category;        // Categoría del libro
    private String isbn;            // Código ISBN
    private Double rating;          // Valoración (1 a 5)
    private Boolean visible;        // Visibilidad del libro (true = visible, false = oculto)
}