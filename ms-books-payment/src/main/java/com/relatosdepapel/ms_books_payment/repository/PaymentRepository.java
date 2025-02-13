package com.relatosdepapel.ms_books_payments.repository;

import com.relatosdepapel.ms_books_payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
