package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    private Integer cant;

    public PurchaseProduct(){}

    public PurchaseProduct(Purchase purchase, Product product, Integer cant) {
        this.purchase = purchase;
        this.product = product;
        this.cant = cant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }
}
