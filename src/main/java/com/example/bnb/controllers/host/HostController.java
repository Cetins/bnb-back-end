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

    @GetMapping("hosts")
    public ResponseEntity getAllHosts() {
        return new ResponseEntity<>(hostRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("hosts/{id}")
    public ResponseEntity getHost(@PathVariable Long id) {
        return new ResponseEntity<>(hostRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/hosts")
    public ResponseEntity<Host> postHost(@RequestBody Host host) {
        hostRepository.save(host);
        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }
}
