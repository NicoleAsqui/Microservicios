package com.relatosdepapel.ms_books_catalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Document(indexName = "books")  // Nombre del índice en Elasticsearch
public class Book {

    @Id
    private String id;

    @NotBlank(message = "El titulo no puede estar vacio")
    @Field(type = FieldType.Search_As_You_Type, name = "title")
    private String title;

    @NotBlank(message = "El autor no puede estar vacio")
    @Field(type = FieldType.Text, name = "author")
    private String author;

    @PastOrPresent(message = "La fecha de publicación no puede ser futura")
    @Field(type = FieldType.Date, name = "publicationDate", format = {}, pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @NotBlank(message = "La categoría no puede estar vacía")
    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Pattern(regexp = "\\d{13}", message = "El ISBN debe tener 13 dígitos")
    @Field(type = FieldType.Keyword, name = "isbn")
    private String isbn;

    @Min(value = 0, message = "La calificación no puede ser negativa")
    @Max(value = 5, message = "La calificación máxima es 5")
    @Field(type = FieldType.Double, name = "rating")
    private Double rating;

    @Field(type = FieldType.Boolean, name = "visible")
    private Boolean visible;

    public Book() {
    }
}