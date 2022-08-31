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

    @GetMapping("/public/reviews")
    public ResponseEntity<Review> getAllReviewsAndFilters(
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "guest_id") Long guest_id,
            @RequestParam(required = false, name = "property_id") Long property_id
    ) {
        if (id != null) {
            return new ResponseEntity(reviewRepository.findById(id), HttpStatus.OK);
        }
        if (guest_id != null) {
            return new ResponseEntity(reviewRepository.findByGuestId(guest_id), HttpStatus.OK);
        }

        if (property_id != null) {
            return new ResponseEntity(reviewRepository.findByPropertyId(property_id), HttpStatus.OK);
        }

        return new ResponseEntity(reviewRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/public/reviews")
    public HttpStatus postReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/public/reviews/{id}")
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

    @DeleteMapping("/public/reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
