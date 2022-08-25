package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Property;
import com.example.bnb.repositories.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAllProperties() {
        return new ResponseEntity<>(propertyRepository.findAll(), HttpStatus.OK);
    }
}
