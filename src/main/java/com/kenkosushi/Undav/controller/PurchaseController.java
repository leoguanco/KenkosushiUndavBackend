package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.Purchase;
import com.kenkosushi.Undav.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController (PurchaseService purchaseService){
        this.purchaseService=purchaseService;
    }

    @PostMapping("/admin/purchases")
    public ResponseEntity<Purchase> addPurchase(Purchase purchase){
        purchaseService.save(purchase);
        return new ResponseEntity<Purchase>(purchase, HttpStatus.CREATED);
    }

}
