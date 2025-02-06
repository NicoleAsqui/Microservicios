package com.relatosdepapel.ms_books_catalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publicationDate;
    private String category;
    private String isbn;
    private Double rating;
    private Boolean visible;

    public Book() {

    }
}