package com.relatosdepapel.payments.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private Date purchaseDate;
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private List<PurchaseItem> items;

}