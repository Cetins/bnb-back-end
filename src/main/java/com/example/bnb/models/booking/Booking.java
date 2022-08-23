package com.example.bnb.models.booking;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "bookingGuest")
//    @JsonIgnoreProperties({"bookings", "id", "password"})
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JsonBackReference(value = "bookingProperty")
//    @JsonIgnoreProperties({"bookings", "id", "rate", "imageUrls", "scenes", "facilities", "amenities", "parkingOptions", "propertyRules", "reviews", "active"})
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(name = "date")
    private String date;

    @Column(name = "nights")
    private Integer nights;

    public Booking(Guest guest, Property property, String date, Integer nights) {
        this.guest = guest;
        this.property = property;
        this.date = date;
        this.nights = nights;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
