package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Amenity;
import com.example.bnb.repositories.property.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AmenityController {

    @Autowired
    AmenityRepository amenityRepository;

    @GetMapping("/amenities")
    public ResponseEntity getAllAmenities() {
        return new ResponseEntity<>(amenityRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/amenities/{id}")
    public ResponseEntity getAmenity(@PathVariable Long id) {
        return new ResponseEntity<>(amenityRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/amenities")
    public HttpStatus postAmenity(@RequestBody Amenity amenity) {
        amenityRepository.save(amenity);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/amenities/{id}")
    public Amenity updateAmenity(@RequestBody Amenity newAmenity, @PathVariable Long id) {
        return amenityRepository.findById(id)
                .map(amenity -> {
                    amenity.setCategory(newAmenity.getCategory());
                    amenity.setTitle(newAmenity.getTitle());
                    amenity.setProperties(newAmenity.getProperties());
                    return amenityRepository.save(amenity);
                })
                .orElseGet(() -> {
                    newAmenity.setId(id);
                    return amenityRepository.save(newAmenity);
                });

    }

    @DeleteMapping("amenities/{id}")
    public ResponseEntity<Amenity> deleteAmenity(@PathVariable Long id) {
        amenityRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
