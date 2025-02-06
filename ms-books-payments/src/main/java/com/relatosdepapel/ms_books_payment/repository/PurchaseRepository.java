package com.relatosdepapel.ms_book_payment.repository;

import com.relatosdepapel.ms_book_payment.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}