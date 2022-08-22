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
}
