package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.PurchasingSystem;
import com.kenkosushi.Undav.service.PurchasingSystemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leo on 11/12/17.
 */

@RestController
public class PurchasingSystemController {
    private static final Log log = LogFactory.getLog(PurchasingSystemController.class);

    private PurchasingSystemService purchasingSystemService;

    @Autowired
    public PurchasingSystemController(PurchasingSystemService purchasingSystemService) {
        this.purchasingSystemService = purchasingSystemService;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/admin/purchasingSystem/{id}")
    public ResponseEntity<PurchasingSystem> updateProduct(@PathVariable Long id,@RequestBody PurchasingSystem purchasingSystem){
        ResponseEntity<PurchasingSystem> response;
        PurchasingSystem purchasingSystem1 = purchasingSystemService.findById(id);

        if(purchasingSystem1 != null){
            purchasingSystemService.update(purchasingSystem);
            response = new ResponseEntity<PurchasingSystem>(purchasingSystem, HttpStatus.OK);
        }else{
            response = new ResponseEntity<PurchasingSystem>(purchasingSystem, HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
