package com.relatosdepapel.ms_book_payment.model;

import jakarta.persistence.*;

@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookId;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}