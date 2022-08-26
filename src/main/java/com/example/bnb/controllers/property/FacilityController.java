package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Facility;
import com.example.bnb.repositories.property.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FacilityController {

    @Autowired
    FacilityRepository facilityRepository;

    @GetMapping("/facilities")
    public ResponseEntity getAllFacilities() {
        return new ResponseEntity<>(facilityRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/facilities/{id}")
    public ResponseEntity getFacility(@PathVariable Long id) {
        return new ResponseEntity<>(facilityRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/facilities")
    public HttpStatus postFacility(@RequestBody Facility facility) {
        facilityRepository.save(facility);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/facilities/{id}")
    public Facility updateFacility(@RequestBody Facility newFacility, @PathVariable Long id) {
        return facilityRepository.findById(id)
                .map(facility -> {
                    facility.setTitle(newFacility.getTitle());
                    facility.setShared(newFacility.getShared());
                    facility.setIconUrl(newFacility.getIconUrl());
                    facility.setProperties(newFacility.getProperties());
                    return facilityRepository.save(facility);
                })
                .orElseGet(() -> {
                    newFacility.setId(id);
                    return facilityRepository.save(newFacility);
                });
    }

    @DeleteMapping("/facilities/{id}")
    public ResponseEntity<Facility> deleteFacility(@PathVariable Long id) {
        facilityRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
