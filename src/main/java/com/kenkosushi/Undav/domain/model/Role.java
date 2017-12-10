package com.kenkosushi.Undav.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role")
    private String role;

    public Role(){}

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
