package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name="purchasing_system")
public class PurchasingSystem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="enable_purchasing_system")
    private Boolean enablePurchasingSystem;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="ending_date")
    private Date endingDate;

    public PurchasingSystem(){}

    public PurchasingSystem(Boolean enablePurchasingSystem, Date startDate, Date endingDate) {
        this.enablePurchasingSystem = enablePurchasingSystem;
        this.startDate = startDate;
        this.endingDate = endingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnablePurchasingSystem() {
        return enablePurchasingSystem;
    }

    public void setEnablePurchasingSystem(Boolean enablePurchasingSystem) {
        this.enablePurchasingSystem = enablePurchasingSystem;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
