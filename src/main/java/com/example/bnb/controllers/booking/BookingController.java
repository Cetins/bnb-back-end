package com.example.bnb.controllers.booking;

import com.example.bnb.models.booking.Booking;
import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.example.bnb.repositories.booking.BookingRepository;
import com.example.bnb.repositories.guest.GuestRepository;
import com.example.bnb.repositories.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/public/bookings")
    public ResponseEntity<List<Booking>>getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/public/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    // , headers={"Accept=*/*","content-type=application/json"} tried to add after value but didn't work !!
    // because content is json string not related the issue i suppose

    @PostMapping(value = "/public/bookings")
    public HttpStatus postBooking(@RequestBody Booking booking) {
        Guest guest = guestRepository.findById(booking.getGuestId()).get();
        Property property = propertyRepository.findById(booking.getPropertyId()).get();
        booking.setGuest(guest);
        booking.setProperty(property);
        bookingRepository.save(booking);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/public/bookings/{id}")
    public Booking updateBooking(@RequestBody Booking newBooking, @PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setGuest(newBooking.getGuest());
                    booking.setProperty(newBooking.getProperty());
                    booking.setDate(newBooking.getDate());
                    booking.setNights(newBooking.getNights());
                    booking.setPeople(newBooking.getPeople());
                    return bookingRepository.save(booking);
                })
                .orElseGet(() -> {
                    newBooking.setId(id);
                    return bookingRepository.save(newBooking);
                });
    }

    @DeleteMapping("/public/bookings/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
