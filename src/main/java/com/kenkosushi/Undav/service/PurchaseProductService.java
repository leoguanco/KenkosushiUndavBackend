package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.PurchaseProduct;
import com.kenkosushi.Undav.domain.repository.PurchaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<PurchaseProduct> findAll(){
        return purchaseProductRepository.findAll();
    }

    public void save(PurchaseProduct purchaseProduct){
        purchaseProductRepository.save(purchaseProduct);
    }

    public void update(PurchaseProduct purchaseProduct){
        purchaseProductRepository.save(purchaseProduct);
    }

    public void delete(Long id){
        purchaseProductRepository.delete(id);
    }
}
