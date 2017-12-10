package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Promotion;
import com.kenkosushi.Undav.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<Promotion> findAll(){
        return promotionRepository.findAll();
    }

    public void save(Promotion promotion){
        promotionRepository.save(promotion);
    }

    public void update(Promotion promotion){
        promotionRepository.save(promotion);
    }

    public void delete(Long id){
        promotionRepository.delete(id);
    }
}
