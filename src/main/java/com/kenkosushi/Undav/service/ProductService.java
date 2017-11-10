package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Product;
import com.kenkosushi.Undav.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product findById(Long id){
        return productRepository.findOne(id);
    }
}
