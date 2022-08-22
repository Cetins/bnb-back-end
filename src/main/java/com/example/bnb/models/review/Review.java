package com.example.bnb.models.review;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private Float rating;

    @ManyToOne
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    public Review(String text, Float rating, Guest guest, Property property) {
        this.text = text;
        this.rating = rating;
        this.guest = guest;
        this.property = property;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
