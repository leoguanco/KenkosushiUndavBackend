package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Product;
import com.kenkosushi.Undav.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<Product> findAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void update(Product product){
        productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.delete(id);
    }
}
