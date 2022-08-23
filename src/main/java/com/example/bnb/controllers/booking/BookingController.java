package com.example.bnb.controllers.booking;

import com.example.bnb.models.booking.Booking;
import com.example.bnb.repositories.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>>getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
