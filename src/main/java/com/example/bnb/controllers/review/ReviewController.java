package com.example.bnb.controllers.review;

import com.example.bnb.models.review.Review;
import com.example.bnb.repositories.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public ResponseEntity getAllReviews() {
        return new ResponseEntity(reviewRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity getReview(@PathVariable Long id) {
        return new ResponseEntity<>(reviewRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public HttpStatus postReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/reviews/{id}")
    Review updateReview(@RequestBody Review newReview, @PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setText(newReview.getText());
                    review.setRating(newReview.getRating());
                    review.setGuest(newReview.getGuest());
                    review.setProperty(newReview.getProperty());
                    return reviewRepository.save(review);
                })
                .orElseGet(() -> {
                    newReview.setId(id);
                    return reviewRepository.save(newReview);
                });
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
