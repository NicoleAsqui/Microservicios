package com.relatosdepapel.payments.controller;

import com.relatosdepapel.payments.model.Purchase;
import com.relatosdepapel.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase processedPurchase = paymentService.processPurchase(purchase);
        return ResponseEntity.ok(processedPurchase);
    }
}