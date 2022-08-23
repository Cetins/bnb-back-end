package com.example.bnb.controllers.guest;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.repositories.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Optional;

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

//    @PatchMapping("/guests/{id}")
//    public ResponseEntity<?> patchGuest(
//            @RequestBody Guest guest,
//            @PathVariable("id") Long id) {
//        guestRepository.save(guest);
//        return ResponseEntity.ok("resource saved");
//    }

//    @PatchMapping("/guests/{id}")
//    public ResponseEntity<Guest> updateGuestPartially(
//            @PathVariable(value = "id") Long id,
//            @Validated @RequestBody Guest guestDetails) throws ResourceNotFoundException {
//        Guest guest = guestRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ id));
//
//        guest.setFirstName(guestDetails.getFirstName());
//        guest.setLastName(guestDetails.getLastName());
//        guest.setEmail(guestDetails.getEmail());
//        guest.setPassword(guestDetails.getPassword());
//        final Guest updatedGuest = guestRepository.save(guest);
//        return ResponseEntity.ok(updatedGuest);
//    }

//    @PatchMapping(value = "/guests/{id}")
//    public ResponseEntity<Guest> patchGuest(@RequestBody Guest guest, @PathVariable Long id) {
//        guestRepository.save(guest);
//        return new ResponseEntity<>(guest, HttpStatus.OK);
//    }

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
