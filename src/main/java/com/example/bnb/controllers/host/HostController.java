package com.example.bnb.controllers.host;

import com.example.bnb.models.host.Host;
import com.example.bnb.repositories.host.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HostController {

    @Autowired
    HostRepository hostRepository;

    @GetMapping("/public/hosts")
    public ResponseEntity<Host> getAllHostsAndFilters(
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "email") String email
    ) {
        if (id != null) {
            return new ResponseEntity(hostRepository.findById(id), HttpStatus.OK);
        }

        if (email != null) {
            return new ResponseEntity(hostRepository.findByEmail(email), HttpStatus.OK);
        }

        return new ResponseEntity(hostRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/public/hosts")
    public HttpStatus postHost(@RequestBody Host host) {
        hostRepository.save(host);
        return(HttpStatus.CREATED);
    }

    @PutMapping("/public/hosts/{id}")
    Host updateHost(@RequestBody Host newHost, @PathVariable Long id) {
        return hostRepository.findById(id)
                .map(host -> {
                    host.setFirstName(newHost.getFirstName());
                    host.setLastName(newHost.getLastName());
                    host.setEmail(newHost.getEmail());
                    host.setPassword(newHost.getPassword());
                    return  hostRepository.save(host);
                })
                .orElseGet(() -> {
                    newHost.setId(id);
                    return  hostRepository.save(newHost);
                });
    }

    @DeleteMapping("/public/hosts/{id}")
    public ResponseEntity<Host> deleteHost(@PathVariable Long id) {
        hostRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
