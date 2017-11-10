package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String address;

    private String floor;

    private String office;

    @Column(name = "type_address")
    private String typeAddress;

    @ManyToOne
    @JoinColumn(name = "user")
    private User userId;

    public Address(){}

    public Address(String address, String floor, String office, String typeAddress, User userId) {
        this.address = address;
        this.floor = floor;
        this.office = office;
        this.typeAddress = typeAddress;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
