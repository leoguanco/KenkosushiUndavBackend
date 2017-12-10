package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name="configuration")
public class Configuration {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="quantity_delivery")
    private Integer quantityDelivery;

    @Column(name="min_delivery_time")
    private Date minDeliveryTime;

    @Column(name="min_delivery_time_ord_adv")
    private Date minDeliveryTimeOrdAdv;

    public Configuration(){}

    public Configuration(Integer quantityDelivery, Date minDeliveryTime, Date minDeliveryTimeOrdAdv) {
        this.quantityDelivery = quantityDelivery;
        this.minDeliveryTime = minDeliveryTime;
        this.minDeliveryTimeOrdAdv = minDeliveryTimeOrdAdv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantityDelivery() {
        return quantityDelivery;
    }

    public void setQuantityDelivery(Integer quantityDelivery) {
        this.quantityDelivery = quantityDelivery;
    }

    public Date getMinDeliveryTime() {
        return minDeliveryTime;
    }

    public void setMinDeliveryTime(Date minDeliveryTime) {
        this.minDeliveryTime = minDeliveryTime;
    }

    public Date getMinDeliveryTimeOrdAdv() {
        return minDeliveryTimeOrdAdv;
    }

    public void setMinDeliveryTimeOrdAdv(Date minDeliveryTimeOrdAdv) {
        this.minDeliveryTimeOrdAdv = minDeliveryTimeOrdAdv;
    }
}
