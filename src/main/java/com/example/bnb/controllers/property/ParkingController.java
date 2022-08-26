package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Parking;
import com.example.bnb.repositories.property.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingController {

    @Autowired
    ParkingRepository parkingRepository;

    @GetMapping("/parking-options")
    public ResponseEntity getAllParkingOptions() {
        return new ResponseEntity<>(parkingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/parking-options/{id}")
    public ResponseEntity getParking(@PathVariable Long id) {
        return new ResponseEntity<>(parkingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/parking-options")
    public HttpStatus postParking(@RequestBody Parking parking) {
        parkingRepository.save(parking);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/parking-options/{id}")
    public Parking updateParking(@RequestBody Parking newParking, @PathVariable Long id) {
        return parkingRepository.findById(id)
                .map(parking -> {
                    parking.setTitle(newParking.getTitle());
                    parking.setFree(newParking.getFree());
                    parking.setProperties(newParking.getProperties());
                    return parkingRepository.save(parking);
                })
                .orElseGet(() -> {
                    newParking.setId(id);
                    return parkingRepository.save(newParking);
                });
    }

    @DeleteMapping("/parking-options/{id}")
    public ResponseEntity<Parking> deleteParking(@PathVariable Long id) {
        parkingRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
