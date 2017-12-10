package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;

/**
 * Created by leo on 11/9/17.
 */
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private Integer phone;

    @Column(name = "type_phone")
    private String typePhone;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Phone(){}

    public Phone(Integer phone, String typePhone, User user) {
        this.phone = phone;
        this.typePhone = typePhone;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
