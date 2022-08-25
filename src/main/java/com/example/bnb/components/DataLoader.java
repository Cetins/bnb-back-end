package com.example.bnb.components;

import com.example.bnb.models.booking.Booking;
import com.example.bnb.models.guest.Guest;
import com.example.bnb.models.host.Host;
import com.example.bnb.models.property.*;
import com.example.bnb.models.review.Review;
import com.example.bnb.repositories.booking.BookingRepository;
import com.example.bnb.repositories.guest.GuestRepository;
import com.example.bnb.repositories.host.HostRepository;
import com.example.bnb.repositories.property.*;
import com.example.bnb.repositories.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    HostRepository hostRepository;

    @Autowired
    AmenityRepository amenityRepository;

    @Autowired
    FacilityRepository facilityRepository;

    @Autowired
    ImageUrlRepository imageUrlRepository;

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyRuleRepository propertyRuleRepository;

    @Autowired
    SceneRepository sceneRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        Guest testGuest1 = new Guest("John", "Harper", "john@mail.com", "123");
        guestRepository.save(testGuest1);

        Guest testGuest2 = new Guest("Stan", "Tarnev", "stan@mail.com", "456");
        guestRepository.save(testGuest2);

        Host testHost1 = new Host("Jarrod", "Bennie", "jarrod@mail.com", "789");
        hostRepository.save(testHost1);

        Property testProperty = new Property(testHost1, true, "house", 3, 95D, "edinburgh", "beautiful house with scene", "12-00", "21-00", "10-00");
        propertyRepository.save(testProperty);

        Amenity testTowel = new Amenity("bathroom", "towel", "http://test-img-url-1");
        amenityRepository.save(testTowel);

        Amenity testTv = new Amenity("entertainment", "TV", "http://test-img-url-2");
        amenityRepository.save(testTv);

        Facility testGarden = new Facility("garden", true);
        facilityRepository.save(testGarden);

        Facility testBalcony = new Facility("balcony", false);
        facilityRepository.save(testBalcony);

        Parking testPark1 = new Parking("off-street", false);
        parkingRepository.save(testPark1);

        Parking testPark2 = new Parking("driveway", true);
        parkingRepository.save(testPark2);

        PropertyRule testNoSmoking = new PropertyRule("Smoking", false);
        propertyRuleRepository.save(testNoSmoking);

        PropertyRule testPets = new PropertyRule("pets", true);
        propertyRuleRepository.save(testPets);

        Scene testRiver = new Scene("river");
        sceneRepository.save(testRiver);

        Scene testCity = new Scene("city");
        sceneRepository.save(testCity);

        testProperty.addScene(testCity);
        testProperty.addFacility(testBalcony);
        testProperty.addAmenity(testTowel);
        testProperty.addAmenity(testTv);
        testProperty.addParkingOption(testPark1);
        testProperty.addPropertyRule(testNoSmoking);
        propertyRepository.save(testProperty);

        ImageUrl testImageUrl1 = new ImageUrl("img1",testProperty);
        ImageUrl testImageUrl2 = new ImageUrl("img2",testProperty);
        ImageUrl testImageUrl3 = new ImageUrl("img3",testProperty);
        ImageUrl testImageUrl4 = new ImageUrl("img4",testProperty);
        ImageUrl testImageUrl5 = new ImageUrl("img5",testProperty);
        ImageUrl testImageUrl6 = new ImageUrl("img6",testProperty);
        ImageUrl testImageUrl7 = new ImageUrl("img7",testProperty);
        ImageUrl testImageUrl8 = new ImageUrl("img8",testProperty);
        ImageUrl testImageUrl9 = new ImageUrl("img9",testProperty);
        ImageUrl testImageUrl10 = new ImageUrl("img10",testProperty);
        ImageUrl testImageUrl11 = new ImageUrl("img11",testProperty);
        ImageUrl testImageUrl12 = new ImageUrl("img12",testProperty);
        ImageUrl testImageUrl13 = new ImageUrl("img13",testProperty);
        ImageUrl testImageUrl14 = new ImageUrl("img14",testProperty);
        ImageUrl testImageUrl15 = new ImageUrl("img15",testProperty);
        imageUrlRepository.save(testImageUrl1);
        imageUrlRepository.save(testImageUrl2);
        imageUrlRepository.save(testImageUrl3);
        imageUrlRepository.save(testImageUrl4);
        imageUrlRepository.save(testImageUrl5);
        imageUrlRepository.save(testImageUrl6);
        imageUrlRepository.save(testImageUrl7);
        imageUrlRepository.save(testImageUrl8);
        imageUrlRepository.save(testImageUrl9);
        imageUrlRepository.save(testImageUrl10);
        imageUrlRepository.save(testImageUrl11);
        imageUrlRepository.save(testImageUrl12);
        imageUrlRepository.save(testImageUrl13);
        imageUrlRepository.save(testImageUrl14);
        imageUrlRepository.save(testImageUrl15);

        testProperty.setCoverImage(testImageUrl5.getUrl());
        propertyRepository.save(testProperty);

        Booking testBooking1 = new Booking(testGuest1, testProperty, "20-09-22", 7);
        bookingRepository.save(testBooking1);

        Booking testBooking2 = new Booking(testGuest2, testProperty, "25-10-22", 3);
        bookingRepository.save(testBooking2);

        Review testReview1 = new Review("Wonderful place to stay", 10F, testGuest1, testProperty);
        reviewRepository.save(testReview1);
    }
}
