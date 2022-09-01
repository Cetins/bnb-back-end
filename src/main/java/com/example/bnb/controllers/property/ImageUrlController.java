package com.example.bnb.controllers.property;

import com.example.bnb.models.property.ImageUrl;
import com.example.bnb.repositories.property.ImageUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageUrlController {

    @Autowired
    ImageUrlRepository imageUrlRepository;

    @GetMapping("/public/image-urls")
    public ResponseEntity getAllImageUrls() {
        return new ResponseEntity<>(imageUrlRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/public/image-urls/{id}")
    public ResponseEntity getImageUrl(@PathVariable Long id) {
        return new ResponseEntity<>(imageUrlRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/public/image-urls")
    public HttpStatus postImageUrl(@RequestBody ImageUrl imageUrl) {
        imageUrlRepository.save(imageUrl);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/public/image-urls/{id}")
    public ImageUrl updateImageUrl(@RequestBody ImageUrl newImageUrl, @PathVariable Long id) {
        return imageUrlRepository.findById(id)
                .map(imageUrl -> {
                    imageUrl.setUrl(newImageUrl.getUrl());
                    imageUrl.setProperty(newImageUrl.getProperty());
                    return imageUrlRepository.save(imageUrl);
                })
                .orElseGet(() -> {
                    newImageUrl.setId(id);
                    return imageUrlRepository.save(newImageUrl);
                });
    }

    @DeleteMapping("/public/image-urls/{id}")
    public ResponseEntity<ImageUrl> deleteImageUrl(@PathVariable Long id) {
        imageUrlRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
