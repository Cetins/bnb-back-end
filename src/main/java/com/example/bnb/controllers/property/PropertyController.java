package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Property;
import com.example.bnb.repositories.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAllProperties() {
        return new ResponseEntity<>(propertyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity getProperty(@PathVariable Long id) {
        return new ResponseEntity<>(propertyRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("properties")
    public HttpStatus postProperty(@RequestBody Property property) {
        propertyRepository.save(property);
        return (HttpStatus.CREATED);
    }

    @PutMapping("properties/{id}")
    public Property updateProperty(@RequestBody Property newProperty, @PathVariable Long id) {
        return propertyRepository.findById(id)
                .map(property -> {
                    property.setHost(newProperty.getHost());
                    property.setActive(newProperty.getActive());
                    property.setType(newProperty.getType());
                    property.setBedCount(newProperty.getBedCount());
                    property.setRate(newProperty.getRate());
                    property.setLocation(newProperty.getLocation());
                    property.setDescription(newProperty.getDescription());
                    property.setImageUrls(newProperty.getImageUrls());
                    property.setCoverImage(newProperty.getCoverImage());
                    property.setScenes(newProperty.getScenes());
                    property.setFacilities(newProperty.getFacilities());
                    property.setAmenities(newProperty.getAmenities());
                    property.setParkingOptions(newProperty.getParkingOptions());
                    property.setPropertyRules(newProperty.getPropertyRules());
                    property.setCheckInAfter(newProperty.getCheckInAfter());
                    property.setCheckInBefore(newProperty.getCheckInBefore());
                    property.setCheckOutBefore(newProperty.getCheckOutBefore());
                    property.setReviews(newProperty.getReviews());
                    property.setBookings(newProperty.getBookings());
                    return propertyRepository.save(property);
                })
                .orElseGet(() -> {
                    newProperty.setId(id);
                    return propertyRepository.save(newProperty);
                });
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Property> deleteProperty(@PathVariable Long id) {
         propertyRepository.deleteById(id);
         return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
