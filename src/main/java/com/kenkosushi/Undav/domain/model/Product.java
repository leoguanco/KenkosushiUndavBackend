package com.kenkosushi.Undav.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private String image;

    private String description;

    private Float price;

    private Boolean marketable;

    private Integer amountPeople;

    public Product(){}

    public Product(String name, String type, String image, String description, Float price, Boolean marketable, Integer amountPeople) {
        this.name = name;
        this.type = type;
        this.image = image;
        this.description = description;
        this.price = price;
        this.marketable = marketable;
        this.amountPeople = amountPeople;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getMarketable() {
        return marketable;
    }

    public void setMarketable(Boolean marketable) {
        this.marketable = marketable;
    }

    public Integer getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(Integer amountPeople) {
        this.amountPeople = amountPeople;
    }
}
