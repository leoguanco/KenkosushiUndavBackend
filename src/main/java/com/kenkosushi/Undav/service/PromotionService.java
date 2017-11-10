package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Promotion;
import com.kenkosushi.Undav.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService (PromotionRepository promotionRepository){
        this.promotionRepository=promotionRepository;
    }

    public Promotion findById(Long id){
        return promotionRepository.findOne(id);
    }
}
