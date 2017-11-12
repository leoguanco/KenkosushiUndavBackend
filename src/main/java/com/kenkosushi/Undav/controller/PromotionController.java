package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.Promotion;
import com.kenkosushi.Undav.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService){
        this.promotionService=promotionService;
    }

    @PostMapping("/admin/promotions/")
    public ResponseEntity<Promotion> addPromotion(Promotion promotion){
        promotionService.save(promotion);
        return new ResponseEntity<Promotion>(promotion, HttpStatus.CREATED);
    }

    @PutMapping("/admin/promotions/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id,Promotion promotion){
        ResponseEntity<Promotion> response;
        Promotion promotion1=promotionService.findById(id);

        if(promotion1!=null){
            promotionService.update(promotion);
            response=new ResponseEntity<Promotion>(promotion1,HttpStatus.OK);
        }
        else{
            response=new ResponseEntity<Promotion>(promotion1,HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/admin/promotions/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        Boolean response;

        promotionService.delete(id);

        Promotion promotion1=promotionService.findById(id);
        if(promotion1==null){
            return true;
        }
        else{
            return false;
        }
    }

    @GetMapping("/promotions")
    public Collection<Promotion> getAllPromotion(){
        return promotionService.findAll();
    }

    @GetMapping("/promotions/{id}")
    public ResponseEntity<Promotion> getProduct(@PathVariable Long id){
        ResponseEntity<Promotion> response;
        Promotion promotion=promotionService.findById(id);

        if(promotion!=null){
            response=new ResponseEntity<Promotion>(promotion,HttpStatus.OK);
        }
        else{
            response = new ResponseEntity<Promotion>(promotion,HttpStatus.NOT_FOUND);
        }

        return response;
    }


}
