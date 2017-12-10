package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct,Long> {
}
