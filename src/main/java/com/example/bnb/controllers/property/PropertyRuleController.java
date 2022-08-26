package com.example.bnb.controllers.property;

import com.example.bnb.models.property.PropertyRule;
import com.example.bnb.repositories.property.PropertyRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyRuleController {

    @Autowired
    PropertyRuleRepository propertyRuleRepository;

    @GetMapping("/property-rules")
    public ResponseEntity getAllPropertyRules() {
        return new ResponseEntity<>(propertyRuleRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/property-rules/{id}")
    public ResponseEntity getPropertyRule(@PathVariable Long id) {
        return new ResponseEntity<>(propertyRuleRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/property-rules")
    public HttpStatus postPropertyRule(@RequestBody PropertyRule propertyRule) {
        propertyRuleRepository.save(propertyRule);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/property-rules/{id}")
    public PropertyRule updatePropertyRule(@RequestBody PropertyRule newPropertyRule, @PathVariable Long id) {
        return propertyRuleRepository.findById(id)
                .map(propertyRule -> {
                    propertyRule.setTitle(newPropertyRule.getTitle());
                    propertyRule.setAllowed(newPropertyRule.getAllowed());
                    propertyRule.setProperties(newPropertyRule.getProperties());
                    return propertyRuleRepository.save(propertyRule);
                })
                .orElseGet(() -> {
                    newPropertyRule.setId(id);
                    return propertyRuleRepository.save(newPropertyRule);
                });
    }

    @DeleteMapping("/property-rules/{id}")
    public ResponseEntity<PropertyRule> deletePropertyRule(@PathVariable Long id) {
        propertyRuleRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
