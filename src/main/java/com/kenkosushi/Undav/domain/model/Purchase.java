package com.kenkosushi.Undav.domain.model;

import javax.persistence.*;

/**
 * Created by leo on 11/9/17.
 */

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type_delivery")
    private String typeDelivery;

    @Column(name = "time_delivery")
    private String timeDelivery;

    private String observations;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToOne
    @JoinColumn(name = "promotion")
    private Promotion promotion;

    public Purchase(){}

    public Purchase(String typeDelivery, String timeDelivery, String observations, User user, Promotion promotion) {
        this.typeDelivery = typeDelivery;
        this.timeDelivery = timeDelivery;
        this.observations = observations;
        this.user = user;
        this.promotion = promotion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(String typeDelivery) {
        this.typeDelivery = typeDelivery;
    }

    public String getTimeDelivery() {
        return timeDelivery;
    }

    public void setTimeDelivery(String timeDelivery) {
        this.timeDelivery = timeDelivery;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
