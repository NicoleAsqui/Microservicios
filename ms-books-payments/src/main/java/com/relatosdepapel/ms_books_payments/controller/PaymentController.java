package com.relatosdepapel.ms_books_payments.controller;


import com.relatosdepapel.ms_books_payments.model.Purchase;
import com.relatosdepapel.ms_books_payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase processedPurchase = paymentService.processPurchase(purchase);
        return ResponseEntity.ok(processedPurchase);
    }
}