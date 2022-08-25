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

    @GetMapping("/hosts")
    public ResponseEntity getAllHosts() {
        return new ResponseEntity<>(hostRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("hosts/{id}")
    public ResponseEntity getHost(@PathVariable Long id) {
        return new ResponseEntity<>(hostRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/hosts")
    public HttpStatus postHost(@RequestBody Host host) {
        hostRepository.save(host);
        return(HttpStatus.CREATED);
    }

    @PutMapping("/hosts/{id}")
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

    @DeleteMapping("/hosts/{id}")
    public ResponseEntity<Host> deleteHost(@PathVariable Long id) {
        hostRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
