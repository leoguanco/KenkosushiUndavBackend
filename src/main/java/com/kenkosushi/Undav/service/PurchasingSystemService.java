package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.PurchasingSystem;
import com.kenkosushi.Undav.domain.repository.PurchasingSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasingSystemService {

    private PurchasingSystemRepository purchasingSystemRepository;

    @Autowired
    public PurchasingSystemService(PurchasingSystemRepository purchasingSystemRepository){
        this.purchasingSystemRepository=purchasingSystemRepository;
    }

    public PurchasingSystem findById(Long id){
        return purchasingSystemRepository.findOne(id);
    }
}
