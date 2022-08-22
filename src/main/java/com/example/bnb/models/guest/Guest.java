package com.example.bnb.models.guest;

import com.example.bnb.models.User;
import com.example.bnb.models.booking.Booking;
import com.example.bnb.models.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest extends User {

    @JsonIgnoreProperties({"guest"})
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonIgnoreProperties({"guest"})
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Guest(String firstName, String lastName, String email, String password, List<Review> reviews, List<Booking> bookings) {
        super(firstName, lastName, email, password);
        this.reviews = reviews;
        this.bookings = bookings;
    }

    public Guest() {}

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
