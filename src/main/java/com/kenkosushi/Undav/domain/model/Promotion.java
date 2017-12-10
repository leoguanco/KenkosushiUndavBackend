package com.kenkosushi.Undav.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue
    private Long id;

    private Date day;

    private Integer percentage;

    public Promotion(){}

    public Promotion(Date day, Integer percentage) {
        this.day = day;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
