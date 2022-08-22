package com.example.bnb.models.booking;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

}
