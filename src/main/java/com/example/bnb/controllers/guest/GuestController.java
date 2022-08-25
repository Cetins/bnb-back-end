package com.example.bnb.controllers.guest;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.repositories.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/guests")
    public ResponseEntity getAllGuests() {
        return new ResponseEntity<>(guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/guests/{id}")
    public ResponseEntity getGuest(@PathVariable Long id) {
        return new ResponseEntity<>(guestRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/guests")
    public HttpStatus postGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/guests/{id}")
    Guest updateGuest(@RequestBody Guest newGuest, @PathVariable Long id) {
        return guestRepository.findById(id)
                .map(guest -> {
                    guest.setFirstName(newGuest.getFirstName());
                    guest.setLastName(newGuest.getLastName());
                    guest.setEmail(newGuest.getEmail());
                    guest.setPassword(newGuest.getPassword());
                    return guestRepository.save(guest);
                })
                .orElseGet(() -> {
                    newGuest.setId(id);
                    return  guestRepository.save(newGuest);
                });
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable Long id) {
        guestRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
