package com.example.bnb.models.review;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "rating")
    private Float rating;

    @ManyToOne
//    @JsonBackReference(value = "reviews1")
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private Long guestId;

    @ManyToOne
//    @JsonBackReference(value = "reviews2")
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private Long propertyId;

    public Review(String text, Float rating, Guest guest, Property property) {
        this.text = text;
        this.rating = rating;
        this.guest = guest;
        this.property = property;
    }

    public Review() {
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
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
