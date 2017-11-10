package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
