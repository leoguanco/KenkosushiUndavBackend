package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.PurchaseProduct;
import com.kenkosushi.Undav.domain.repository.PurchaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProductService {

    private PurchaseProductRepository purchaseProductRepository;

    @Autowired
    public PurchaseProductService(PurchaseProductRepository purchaseProductRepository){
        this.purchaseProductRepository=purchaseProductRepository;
    }

    public PurchaseProduct findById(Long id){
        return purchaseProductRepository.findOne(id);
    }
}
