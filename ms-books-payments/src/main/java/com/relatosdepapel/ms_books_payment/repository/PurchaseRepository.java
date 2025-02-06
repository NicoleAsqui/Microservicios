package com.relatosdepapel.payments.repository;

import com.relatosdepapel.payments.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}