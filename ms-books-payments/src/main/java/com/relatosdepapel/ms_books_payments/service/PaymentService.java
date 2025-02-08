package com.relatosdepapel.ms_books_payments.service;

import com.relatosdepapel.ms_books_payments.client.BookClient;
import com.relatosdepapel.ms_books_payments.model.Purchase;
import com.relatosdepapel.ms_books_payments.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BookClient bookClient;

    @Transactional
    public Purchase processPurchase(Purchase purchase) {

        return purchaseRepository.save(purchase);
    }
}