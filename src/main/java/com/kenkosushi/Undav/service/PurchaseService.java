package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Purchase;
import com.kenkosushi.Undav.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository=purchaseRepository;
    }

    public Purchase findById(Long id){
        return purchaseRepository.findOne(id);
    }

    public Collection<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    public void save(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    public void update (Purchase purchase){
        purchaseRepository.save(purchase);
    }

    public void delete(Long id){
        purchaseRepository.delete(id);
    }
}
