package com.example.bnb.controllers.review;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.property.Property;
import com.example.bnb.models.review.Review;
import com.example.bnb.repositories.guest.GuestRepository;
import com.example.bnb.repositories.property.PropertyRepository;
import com.example.bnb.repositories.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/public/reviews")
    public ResponseEntity<Review> getAllReviewsAndFilters(
            @RequestParam(required = false, name = "id") Long id
    ) {
        if (id != null) {
            return new ResponseEntity(reviewRepository.findById(id), HttpStatus.OK);
        }

        return new ResponseEntity(reviewRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/public/reviews")
    public HttpStatus postReview(@RequestBody Review review) {
        Guest guest = guestRepository.findById(review.getGuestId()).get();
        Property property = propertyRepository.findById(review.getPropertyId()).get();
        review.setGuest(guest);
        review.setProperty(property);
        reviewRepository.save(review);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/public/reviews/{id}")
    Review updateReview(@RequestBody Review newReview, @PathVariable Long id) {
        Guest guest = guestRepository.findById(newReview.getGuestId()).get();
        Property property = propertyRepository.findById(newReview.getPropertyId()).get();
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setText(newReview.getText());
                    review.setRating(newReview.getRating());
                    review.setGuest(guest);
                    review.setProperty(property);
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
