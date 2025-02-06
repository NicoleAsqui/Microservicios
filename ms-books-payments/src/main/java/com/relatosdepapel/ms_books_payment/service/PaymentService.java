package com.relatosdepapel.ms_book_payment.service;

import com.relatosdepapel.ms_book_payment.model.Book;
import com.relatosdepapel.ms_book_payment.client.BookClient;
import com.relatosdepapel.ms_book_payment.model.Purchase;
import com.relatosdepapel.ms_book_payment.model.PurchaseItem;
import com.relatosdepapel.ms_book_payment.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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