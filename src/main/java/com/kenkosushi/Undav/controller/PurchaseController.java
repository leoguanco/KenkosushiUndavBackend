package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.Purchase;
import com.kenkosushi.Undav.domain.model.PurchaseProduct;
import com.kenkosushi.Undav.service.PurchaseProductService;
import com.kenkosushi.Undav.service.PurchaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PurchaseController {
    private static final Log log = LogFactory.getLog(PurchaseController.class);

    private PurchaseService purchaseService;
    private PurchaseProductService purchaseProductService;
    private JavaMailSender mailSender;

    @Autowired
    public PurchaseController (PurchaseService purchaseService,PurchaseProductService purchaseProductService){
        this.purchaseService=purchaseService;
        this.purchaseProductService=purchaseProductService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/purchases")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase,@RequestBody PurchaseProduct purchaseProduct){
        purchaseProductService.save(purchaseProduct);
        purchaseService.save(purchase);
        return new ResponseEntity<Purchase>(purchase, HttpStatus.CREATED);
    }

}
