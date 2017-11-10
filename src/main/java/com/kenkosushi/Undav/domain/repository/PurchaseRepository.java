package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}