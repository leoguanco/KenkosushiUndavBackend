package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.Product;
import com.kenkosushi.Undav.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by leo on 11/12/17.
 */

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/products/")
    public ResponseEntity<Product> addProduct(Product product){
        productService.save(product);
        return new ResponseEntity<Product>(product,HttpStatus.CREATED);
    }

    @PutMapping("/admin/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product product){
        ResponseEntity<Product> response;
        Product product1 = productService.findById(id);

        if(product1 != null){
            productService.update(product);
            response = new ResponseEntity<Product>(product, HttpStatus.OK);
        }else{
            response = new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @DeleteMapping("/admin/products/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        productService.delete(id);
        Product product = productService.findById(id);

        if(product == null){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/public/products/")
    public Collection<Product> getAllProduct(){
        return productService.findAll();
    }

    @GetMapping("/public/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        ResponseEntity<Product> response;
        Product product = productService.findById(id);

        if(product != null){
            response = new ResponseEntity<Product>(product, HttpStatus.OK);
        }else{
            response = new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
