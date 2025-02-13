package com.relatosdepapel.ms_books_payments.service;

import com.relatosdepapel.ms_books_payments.model.Payment;
import com.relatosdepapel.ms_books_payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String BOOKS_CATALOGUE_URL = "http://localhost:8081/books";

    public Payment createPayment(Payment payment) {
        // Validar si el libro existe en el catálogo antes de procesar el pago
        String bookUrl = BOOKS_CATALOGUE_URL + "/" + payment.getBookId();
        try {
            restTemplate.getForObject(bookUrl, Object.class);
            return paymentRepository.save(payment);
        } catch (Exception e) {
            throw new IllegalArgumentException("El libro con ID " + payment.getBookId() + " no existe.");
        }
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
