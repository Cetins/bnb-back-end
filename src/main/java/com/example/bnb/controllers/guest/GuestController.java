package com.example.bnb.controllers.guest;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.repositories.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @CrossOrigin("*")
    @GetMapping("/public/guests")
    public ResponseEntity<Guest> getAllGuestsAndFilters(
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "id") Long id
    ) {
        if (id != null) {
            return new ResponseEntity(guestRepository.findById(id), HttpStatus.OK);
        }

        if (email != null) {
            return new ResponseEntity(guestRepository.findByEmail(email), HttpStatus.OK);
        }

        return new ResponseEntity(guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/public/guests/{id}")
    public ResponseEntity getGuestById(@PathVariable Long id) {
        return new ResponseEntity<>(guestRepository.findById(id), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping(value = "/public/guests")
    public HttpStatus postGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
        return (HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @PutMapping("/public/guests/{id}")
    public Guest updateGuest(@RequestBody Guest newGuest, @PathVariable Long id) {
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

    @CrossOrigin("*")
    @DeleteMapping("/public/guests/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable Long id) {
        guestRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
