package com.relatosdepapel.ms_book_payment.service;

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
        // Validar cada ítem con ms-books-catalogue
        for (PurchaseItem item : purchase.getItems()) {
            Book book = bookClient.getBookById(item.getBookId());

            if (book == null || !book.isVisible() || book.getStock() < item.getQuantity()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El libro no está disponible: " + item.getBookId());
            }
        }

        // Persistir la compra en la base de datos
        return purchaseRepository.save(purchase);
    }
}