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

import java.util.ArrayList;
import java.util.Arrays;

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
                //  Guests

                Guest sushi = new Guest("Sushi", "Cetin", "sushi@mail.com", "4687656");
                guestRepository.save(sushi);

                //  Hosts

                Host john = new Host("John", "Harper", "john@mail.com", "1245453");
                hostRepository.save(john);

                Host stan = new Host("Stan", "Tarnev", "stan@mail.com", "42454556");
                hostRepository.save(stan);

                Host jarrod = new Host("Jarrod", "Bennie", "jarrod@mail.com", "7453453289");
                hostRepository.save(jarrod);

                //  Properties

                Property property1 = new Property(jarrod, true, "flat", 1, 95D, "edinburgh","Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12-00", "21-00", "10-00");
                propertyRepository.save(property1);

                Property property2 = new Property(stan, true, "room", 1, 85D, "london", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12-00", "21-00", "10-00");
                propertyRepository.save(property2);

                Property property3 = new Property(john, true, "house", 3,  230D, "glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12-00", "21-00", "10-00");
                propertyRepository.save(property3);

                Property property4 = new Property(john, true, "house", 2, 120D, "glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12-00", "21-00", "10-00");
                propertyRepository.save(property4);

                //  Amenities

                Amenity hairDryer = new Amenity("Bathroom", "Hair Dryer");
                amenityRepository.save(hairDryer);

                Amenity cleaningProducts = new Amenity("Bathroom", "Cleaning Products");
                amenityRepository.save(cleaningProducts);

                Amenity hotWater = new Amenity("Bathroom", "Hot Water");
                amenityRepository.save(hotWater);

                Amenity washingMachine = new Amenity("Bathroom", "Washing Machine");
                amenityRepository.save(washingMachine);

                Amenity dryer = new Amenity("Bathroom", "Dryer");
                amenityRepository.save(dryer);

                Amenity shampoo = new Amenity("Bathroom", "Shampoo");
                amenityRepository.save(shampoo);

                Amenity towels = new Amenity("Bedroom", "Towels");
                amenityRepository.save(towels);

                Amenity bedSheets = new Amenity("Bedroom", "Bed Sheets");
                amenityRepository.save(bedSheets);

                Amenity iron = new Amenity("Bedroom", "Iron");
                amenityRepository.save(iron);

                Amenity hangers = new Amenity("Bedroom", "Hangers");
                amenityRepository.save(hangers);

                Amenity wifi = new Amenity("Entertainment", "WiFi");
                amenityRepository.save(wifi);

                Amenity recordPlayer = new Amenity("Entertainment", "Record Player");
                amenityRepository.save(recordPlayer);

                Amenity tv = new Amenity("Entertainment", "TV");
                amenityRepository.save(tv);

                Amenity streamingServices = new Amenity("Entertainment", "Streaming Services");
                amenityRepository.save(streamingServices);

                Amenity woodFireplace = new Amenity("Heating", "Wood Fireplace");
                amenityRepository.save(woodFireplace);

                Amenity electricFireplace = new Amenity("Heating", "Electric Fireplace");
                amenityRepository.save(electricFireplace);

                Amenity cooler = new Amenity("Heating", "Cooler");
                amenityRepository.save(cooler);

                Amenity airConditioner = new Amenity("Heating", "Air Conditioner");
                amenityRepository.save(airConditioner);

                Amenity centralGas = new Amenity("Heating", "Central Gas");
                amenityRepository.save(centralGas);

                Amenity centralElectric = new Amenity("Heating", "Central Electric");
                amenityRepository.save(centralElectric);

                Amenity kitchenEssentials = new Amenity("Kitchen", "Kitchen Essentials");
                amenityRepository.save(kitchenEssentials);

                Amenity oven = new Amenity("Kitchen", "Oven");
                amenityRepository.save(oven);

                Amenity cooker = new Amenity("Kitchen", "Cooker");
                amenityRepository.save(cooker);

                Amenity microwave = new Amenity("Kitchen", "Microwave");
                amenityRepository.save(microwave);

                Amenity dishwasher = new Amenity("Kitchen", "Dishwasher");
                amenityRepository.save(dishwasher);

                Amenity refrigerator = new Amenity("Kitchen", "Refrigerator");
                amenityRepository.save(refrigerator);

                Amenity freezer = new Amenity("Kitchen", "Freezer");
                amenityRepository.save(freezer);

                Amenity coffeeMaker = new Amenity("Kitchen", "Coffee Maker");
                amenityRepository.save(coffeeMaker);

                Amenity smokeAlarm = new Amenity("Security", "Smoke Alarm");
                amenityRepository.save(smokeAlarm);

                Amenity carbonMonoxide = new Amenity("Security", "Carbon Monoxide Alarm");
                amenityRepository.save(carbonMonoxide);

                Amenity securityCameras = new Amenity("Security", "Security Cameras");
                amenityRepository.save(securityCameras);

                Amenity secureEntry = new Amenity("Security", "Secure Entry");
                amenityRepository.save(secureEntry);

                Amenity workSpace = new Amenity("Extras", "Dedicated Work Space");
                amenityRepository.save(workSpace);

                ArrayList<Amenity> amenities1 = new ArrayList<>(Arrays.asList(hairDryer, cleaningProducts, washingMachine, shampoo, towels, iron, hangers, tv, streamingServices, centralGas, smokeAlarm, wifi));
                ArrayList<Amenity> amenities2 = new ArrayList<>(Arrays.asList(cleaningProducts, dryer, washingMachine, towels, hangers, tv, airConditioner, oven, kitchenEssentials, microwave, coffeeMaker, smokeAlarm, wifi, workSpace));

                property1.setAmenities(amenities1);
                propertyRepository.save(property1);

                property2.setAmenities(amenities2);
                propertyRepository.save(property2);

                property3.setAmenities(amenities1);
                propertyRepository.save(property3);

                property4.setAmenities(amenities2);
                propertyRepository.save(property4);

                //  Facilities

                Facility garden = new Facility("Garden", false, "yard");
                facilityRepository.save(garden);

                Facility indoorPool = new Facility("Indoor Pool", false, "waves");
                facilityRepository.save(indoorPool);

                Facility outdoorPool = new Facility("Outdoor Pool", false, "pool");
                facilityRepository.save(outdoorPool);

                Facility hotTub = new Facility("Hot tub", false, "hot_tub");
                facilityRepository.save(hotTub);

                Facility balcony = new Facility("balcony", false, "balcony");
                facilityRepository.save(balcony);

                property1.addFacility(garden);
                property1.addFacility(hotTub);
                propertyRepository.save(property1);

                property2.addFacility(garden);
                property2.addFacility(balcony);
                propertyRepository.save(property2);

                property3.addFacility(garden);
                property3.addFacility(outdoorPool);
                propertyRepository.save(property3);

                property4.addFacility(balcony);
                propertyRepository.save(property4);


                //  Parking

                Parking offStreet = new Parking("Off-street Parking", true);
                parkingRepository.save(offStreet);

                Parking garage = new Parking("Garage", true);
                parkingRepository.save(garage);

                Parking driveway = new Parking("Driveway", true);
                parkingRepository.save(driveway);

                Parking reserved = new Parking("Reserved Parking Space", true);
                parkingRepository.save(reserved);

                property1.addParkingOption(offStreet);
                propertyRepository.save(property1);

                property2.addParkingOption(offStreet);
                propertyRepository.save(property2);

                property3.addParkingOption(driveway);
                property3.addParkingOption(garage);
                propertyRepository.save(property3);

                property3.addParkingOption(reserved);
                propertyRepository.save(property4);

                //  Rules

                PropertyRule smoking = new PropertyRule("Smoking", false);
                propertyRuleRepository.save(smoking);

                PropertyRule pets = new PropertyRule("Pets", false);
                propertyRuleRepository.save(pets);

                PropertyRule party = new PropertyRule("Party", false);
                propertyRuleRepository.save(party);

                property1.addPropertyRule(smoking);
                property1.addPropertyRule(party);
                propertyRepository.save(property1);

                property2.addPropertyRule(smoking);
                property2.addPropertyRule(party);
                propertyRepository.save(property2);

                property3.addPropertyRule(smoking);
                propertyRepository.save(property3);

                property3.addPropertyRule(smoking);
                propertyRepository.save(property4);

                //  Scenes

                Scene river = new Scene("River");
                sceneRepository.save(river);

                Scene city = new Scene("City");
                sceneRepository.save(city);

                Scene citySkyline = new Scene("City Skyline");
                sceneRepository.save(citySkyline);

                Scene nature =  new Scene("Nature");
                sceneRepository.save(nature);

                Scene mountain =  new Scene("Mountain");
                sceneRepository.save(mountain);

                Scene sea =  new Scene("Sea");
                sceneRepository.save(sea);

                Scene forest =  new Scene("Forest");
                sceneRepository.save(forest);

                property1.addScene(city);
                propertyRepository.save(property1);

                property2.addScene(nature);
                propertyRepository.save(property2);

                property3.addScene(mountain);
                property3.addScene(sea);
                property3.addScene(nature);
                propertyRepository.save(property3);

                property4.addScene(citySkyline);
                propertyRepository.save(property4);

                //  Image urls

                ImageUrl url1 = new ImageUrl("img1",property1);
                imageUrlRepository.save(url1);

                ImageUrl url2 = new ImageUrl("img2",property1);
                imageUrlRepository.save(url2);

                ImageUrl url3 = new ImageUrl("img3",property1);
                imageUrlRepository.save(url3);

                ImageUrl url4 = new ImageUrl("img4",property1);
                imageUrlRepository.save(url4);

                ImageUrl url5 = new ImageUrl("img5",property1);
                imageUrlRepository.save(url5);

                ImageUrl url6 = new ImageUrl("img6",property2);
                imageUrlRepository.save(url6);

                ImageUrl url7 = new ImageUrl("img7",property2);
                imageUrlRepository.save(url7);

                ImageUrl url8 = new ImageUrl("img8",property2);
                imageUrlRepository.save(url8);

                ImageUrl url9 = new ImageUrl("img9",property2);
                imageUrlRepository.save(url9);

                ImageUrl url10 = new ImageUrl("img10",property2);
                imageUrlRepository.save(url10);

                ImageUrl url11 = new ImageUrl("img11",property3);
                imageUrlRepository.save(url11);

                ImageUrl url12 = new ImageUrl("img12",property3);
                imageUrlRepository.save(url12);

                ImageUrl url13 = new ImageUrl("img13",property3);
                imageUrlRepository.save(url13);

                ImageUrl url14 = new ImageUrl("img14",property3);
                imageUrlRepository.save(url14);

                ImageUrl url15 = new ImageUrl("img15",property3);
                imageUrlRepository.save(url15);

                ImageUrl url16 = new ImageUrl("img16",property4);
                imageUrlRepository.save(url16);

                ImageUrl url17 = new ImageUrl("img16",property4);
                imageUrlRepository.save(url17);

                ImageUrl url18 = new ImageUrl("img16",property4);
                imageUrlRepository.save(url18);

                ImageUrl url19 = new ImageUrl("img16",property4);
                imageUrlRepository.save(url19);

                ImageUrl url20 = new ImageUrl("img16",property4);
                imageUrlRepository.save(url20);

                property1.setCoverImage(url1.getUrl());
                propertyRepository.save(property1);

                property2.setCoverImage(url6.getUrl());
                propertyRepository.save(property2);

                property3.setCoverImage(url10.getUrl());
                propertyRepository.save(property3);

                property4.setCoverImage(url15.getUrl());
                propertyRepository.save(property4);

                //  Bookings

                Booking testBooking1 = new Booking(sushi, property1, "20-09-22", 7, 2);
                bookingRepository.save(testBooking1);

                Booking testBooking2 = new Booking(sushi, property3, "25-10-22", 3, 2);
                bookingRepository.save(testBooking2);

                //  Reviews

                Review testReview1 = new Review("Wonderful place to stay", 10F, sushi, property1);
                reviewRepository.save(testReview1);

                Review testReview2 = new Review("Great place to stay", 10F, sushi, property2);
                reviewRepository.save(testReview2);

                Review testReview3 = new Review("Beautiful views", 10F, sushi, property3);
                reviewRepository.save(testReview3);

                Review testReview4 = new Review("Perfect location", 10F, sushi, property4);
                reviewRepository.save(testReview4);

                Review testReview5 = new Review("Negative experience", 4F, sushi, property2);
                reviewRepository.save(testReview5);

                Review testReview6 = new Review("Not happy this time", 2F, sushi, property4);
                reviewRepository.save(testReview6);
        }
}


