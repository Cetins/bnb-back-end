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

                Guest charlie = new Guest("Charlie", "Cetin", "charlie@mail.com", "4687656");
                guestRepository.save(charlie);

                Guest scott = new Guest("Scott", "Green", "scott@mail.com", "4687656");
                guestRepository.save(scott);

                Guest christine = new Guest("Christine", "Blue", "christine@mail.com", "4687656");
                guestRepository.save(christine);

                Guest tracey = new Guest("Tracey", "Pink", "tracey@mail.com", "4687656");
                guestRepository.save(tracey);

                //  Hosts

                Host john = new Host("John", "Harper", "john@mail.com", "1245453");
                hostRepository.save(john);

                Host stan = new Host("Stan", "Tarnev", "stan@mail.com", "42454556");
                hostRepository.save(stan);

                Host jarrod = new Host("Jarrod", "Bennie", "jarrod@mail.com", "7453453289");
                hostRepository.save(jarrod);

                //  Properties

                Property property1 = new Property(jarrod, true, "Flat", 1, 95D, "Edinburgh","Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "11:00");
                propertyRepository.save(property1);

                Property property2 = new Property(stan, true, "Room", 1, 85D, "London", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property2);

                Property property3 = new Property(john, true, "House", 3,  230D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property3);

                Property property4 = new Property(john, true, "House", 2, 120D, "London", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "12:00");
                propertyRepository.save(property4);

                Property property5 = new Property(jarrod, true, "House", 2, 120D, "Edinburgh", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property5);

                Property property6 = new Property(jarrod, true, "Flat", 3, 85D, "Edinburgh", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "11 :00", "21:00", "12:00");
                propertyRepository.save(property6);

                Property property7 = new Property(jarrod, true, "House", 2, 120D, "London", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "10:00", "21:00", "11:00");
                propertyRepository.save(property7);

                Property property8 = new Property(john, true, "House", 4, 90D, "London", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property8);

                Property property9 = new Property(john, true, "Flat", 4, 130D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "11:00", "21:00", "11:00");
                propertyRepository.save(property9);

                Property property10 = new Property(stan, true, "House", 2, 85D, "Edinburgh", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property10);

                Property property11 = new Property(john, true, "Flat", 2, 95D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property11);

                Property property12 = new Property(stan, true, "House", 3, 140D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property12);

                Property property13 = new Property(stan, true, "Flat", 3, 85D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit. Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property13);

                Property property14 = new Property(john, true, "House", 3, 120D, "Glasgow", "Lorem ipsum dolor sit amet. Nam nihil repellat et dolorum veniam sed iste modi ad dolore pariatur vel laborum tenetur. A dicta perferendis ea blanditiis maxime aut molestiae voluptatum aut dignissimos reprehenderit", "12:00", "21:00", "10:00");
                propertyRepository.save(property14);

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
                property2.setAmenities(amenities2);
                property3.setAmenities(amenities1);
                property4.setAmenities(amenities2);
                property5.setAmenities(amenities1);
                property6.setAmenities(amenities2);
                property7.setAmenities(amenities1);
                property8.setAmenities(amenities1);
                property9.setAmenities(amenities2);
                property10.setAmenities(amenities1);
                property11.setAmenities(amenities1);
                property12.setAmenities(amenities2);
                property13.setAmenities(amenities1);
                property14.setAmenities(amenities1);

                //  Facilities

                Facility garden = new Facility("Garden", false, "yard");
                facilityRepository.save(garden);

                Facility indoorPool = new Facility("Indoor Pool", false, "waves");
                facilityRepository.save(indoorPool);

                Facility outdoorPool = new Facility("Outdoor Pool", false, "pool");
                facilityRepository.save(outdoorPool);

                Facility hotTub = new Facility("Hot tub", false, "hot_tub");
                facilityRepository.save(hotTub);

                Facility balcony = new Facility("Balcony", false, "balcony");
                facilityRepository.save(balcony);

                property1.addFacility(garden);
                property1.addFacility(hotTub);

                property2.addFacility(garden);
                property2.addFacility(balcony);

                property3.addFacility(garden);
                property3.addFacility(outdoorPool);

                property4.addFacility(balcony);

                property5.addFacility(balcony);
                property5.addFacility(garden);
                property5.addFacility(hotTub);

                property6.addFacility(balcony);
                property6.addFacility(garden);

                property7.addFacility(balcony);
                property7.addFacility(garden);

                property8.addFacility(hotTub);
                property8.addFacility(balcony);
                property8.addFacility(garden);

                property9.addFacility(balcony);
                property9.addFacility(garden);

                property10.addFacility(balcony);

                property11.addFacility(balcony);
                property11.addFacility(garden);

                property12.addFacility(hotTub);
                property12.addFacility(balcony);

                property13.addFacility(hotTub);
                property13.addFacility(garden);
                property13.addFacility(outdoorPool);

                property14.addFacility(outdoorPool);
                property14.addFacility(indoorPool);
                property14.addFacility(hotTub);
                property14.addFacility(balcony);



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

                property2.addParkingOption(offStreet);

                property3.addParkingOption(driveway);
                property3.addParkingOption(garage);

                property3.addParkingOption(reserved);
                property4.addParkingOption(driveway);
                property5.addParkingOption(offStreet);
                property6.addParkingOption(driveway);
                property7.addParkingOption(reserved);
                property8.addParkingOption(driveway);
                property9.addParkingOption(driveway);
                property10.addParkingOption(reserved);
                property11.addParkingOption(offStreet);
                property12.addParkingOption(offStreet);
                property13.addParkingOption(driveway);
                property14.addParkingOption(garage);
                property14.addParkingOption(driveway);

                //  Rules

                PropertyRule smoking = new PropertyRule("Smoking", false);
                propertyRuleRepository.save(smoking);

                PropertyRule pets = new PropertyRule("Pets", false);
                propertyRuleRepository.save(pets);

                PropertyRule party = new PropertyRule("Party", false);
                propertyRuleRepository.save(party);

                property1.addPropertyRule(smoking);
                property1.addPropertyRule(party);
                property2.addPropertyRule(smoking);
                property2.addPropertyRule(party);
                property3.addPropertyRule(smoking);
                property3.addPropertyRule(smoking);

//                property4.addPropertyRule(smoking);
//                property5.addPropertyRule(party);
//                property6.addPropertyRule(smoking);
//                property7.addPropertyRule(smoking);
//                property8.addPropertyRule(smoking);
//                property9.addPropertyRule(smoking);
//                property10.addPropertyRule(smoking);
//                property11.addPropertyRule(smoking);
//                property12.addPropertyRule(smoking);
//                property13.addPropertyRule(smoking);
//                property14.addPropertyRule(smoking);
//                property14.addPropertyRule(party);

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
                property2.addScene(nature);
                property3.addScene(mountain);
                property3.addScene(sea);
                property3.addScene(nature);
                property4.addScene(citySkyline);
                property5.addScene(city);
                property6.addScene(nature);
                property7.addScene(mountain);
                property8.addScene(sea);
                property9.addScene(nature);
                property10.addScene(citySkyline);
                property11.addScene(city);
                property12.addScene(nature);
                property13.addScene(mountain);
                property13.addScene(sea);
                property13.addScene(nature);
                property14.addScene(citySkyline);

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
                ImageUrl url17 = new ImageUrl("img17",property4);
                imageUrlRepository.save(url17);
                ImageUrl url18 = new ImageUrl("img18",property4);
                imageUrlRepository.save(url18);
                ImageUrl url19 = new ImageUrl("img19",property4);
                imageUrlRepository.save(url19);
                ImageUrl url20 = new ImageUrl("img20",property4);
                imageUrlRepository.save(url20);
                ImageUrl url21 = new ImageUrl("img21",property5);
                imageUrlRepository.save(url21);
                ImageUrl url22 = new ImageUrl("img22",property5);
                imageUrlRepository.save(url22);
                ImageUrl url23 = new ImageUrl("img23",property5);
                imageUrlRepository.save(url23);
                ImageUrl url24 = new ImageUrl("img24",property5);
                imageUrlRepository.save(url24);
                ImageUrl url25 = new ImageUrl("img25",property5);
                imageUrlRepository.save(url25);
                ImageUrl url26 = new ImageUrl("img1",property6);
                imageUrlRepository.save(url26);
                ImageUrl url27 = new ImageUrl("img2",property6);
                imageUrlRepository.save(url27);
                ImageUrl url28 = new ImageUrl("img3",property6);
                imageUrlRepository.save(url28);
                ImageUrl url29 = new ImageUrl("img4",property6);
                imageUrlRepository.save(url29);
                ImageUrl url30 = new ImageUrl("img10",property6);
                imageUrlRepository.save(url30);
                ImageUrl url31 = new ImageUrl("img11",property7);
                imageUrlRepository.save(url31);
                ImageUrl url32 = new ImageUrl("img12",property7);
                imageUrlRepository.save(url32);
                ImageUrl url33 = new ImageUrl("img13",property7);
                imageUrlRepository.save(url33);
                ImageUrl url34 = new ImageUrl("img14",property7);
                imageUrlRepository.save(url34);
                ImageUrl url35 = new ImageUrl("img15",property7);
                imageUrlRepository.save(url35);
                ImageUrl url36 = new ImageUrl("img16",property8);
                imageUrlRepository.save(url36);
                ImageUrl url37 = new ImageUrl("img17",property8);
                imageUrlRepository.save(url37);
                ImageUrl url38 = new ImageUrl("img18",property8);
                imageUrlRepository.save(url38);
                ImageUrl url39 = new ImageUrl("img19",property8);
                imageUrlRepository.save(url39);
                ImageUrl url40 = new ImageUrl("img20",property8);
                imageUrlRepository.save(url40);
                ImageUrl url41 = new ImageUrl("img21",property9);
                imageUrlRepository.save(url41);
                ImageUrl url42 = new ImageUrl("img22",property9);
                imageUrlRepository.save(url42);
                ImageUrl url43 = new ImageUrl("img23",property9);
                imageUrlRepository.save(url43);
                ImageUrl url44 = new ImageUrl("img24",property9);
                imageUrlRepository.save(url44);
                ImageUrl url45 = new ImageUrl("img25",property9);
                imageUrlRepository.save(url45);
                ImageUrl url46 = new ImageUrl("img6",property10);
                imageUrlRepository.save(url46);
                ImageUrl url47 = new ImageUrl("img7",property10);
                imageUrlRepository.save(url47);
                ImageUrl url48 = new ImageUrl("img8",property10);
                imageUrlRepository.save(url48);
                ImageUrl url49 = new ImageUrl("img9",property10);
                imageUrlRepository.save(url49);
                ImageUrl url50 = new ImageUrl("img10",property10);
                imageUrlRepository.save(url50);
                ImageUrl url51 = new ImageUrl("img11",property11);
                imageUrlRepository.save(url51);
                ImageUrl url52 = new ImageUrl("img12",property11);
                imageUrlRepository.save(url52);
                ImageUrl url53 = new ImageUrl("img13",property11);
                imageUrlRepository.save(url53);
                ImageUrl url54 = new ImageUrl("img14",property11);
                imageUrlRepository.save(url54);
                ImageUrl url55 = new ImageUrl("img15",property11);
                imageUrlRepository.save(url55);
                ImageUrl url56 = new ImageUrl("img16",property12);
                imageUrlRepository.save(url56);
                ImageUrl url57 = new ImageUrl("img17",property12);
                imageUrlRepository.save(url57);
                ImageUrl url58 = new ImageUrl("img18",property12);
                imageUrlRepository.save(url58);
                ImageUrl url59 = new ImageUrl("img19",property12);
                imageUrlRepository.save(url59);
                ImageUrl url60 = new ImageUrl("img20",property12);
                imageUrlRepository.save(url60);
                ImageUrl url61 = new ImageUrl("img21",property13);
                imageUrlRepository.save(url61);
                ImageUrl url62 = new ImageUrl("img22",property13);
                imageUrlRepository.save(url62);
                ImageUrl url63 = new ImageUrl("img23",property13);
                imageUrlRepository.save(url63);
                ImageUrl url64 = new ImageUrl("img24",property13);
                imageUrlRepository.save(url64);
                ImageUrl url65 = new ImageUrl("img25",property13);
                imageUrlRepository.save(url65);
                ImageUrl url66 = new ImageUrl("img6",property14);
                imageUrlRepository.save(url66);
                ImageUrl url67 = new ImageUrl("img7",property14);
                imageUrlRepository.save(url67);
                ImageUrl url68 = new ImageUrl("img8",property14);
                imageUrlRepository.save(url68);
                ImageUrl url69 = new ImageUrl("img9",property14);
                imageUrlRepository.save(url69);
                ImageUrl url70 = new ImageUrl("img10",property14);
                imageUrlRepository.save(url70);

                property1.setCoverImage(url1.getUrl());
                property2.setCoverImage(url2.getUrl());
                property3.setCoverImage(url3.getUrl());
                property4.setCoverImage(url4.getUrl());
                property5.setCoverImage(url5.getUrl());
                property6.setCoverImage(url6.getUrl());
                property7.setCoverImage(url7.getUrl());
                property8.setCoverImage(url8.getUrl());
                property9.setCoverImage(url9.getUrl());
                property10.setCoverImage(url10.getUrl());
                property11.setCoverImage(url11.getUrl());
                property12.setCoverImage(url12.getUrl());
                property13.setCoverImage(url13.getUrl());
                property14.setCoverImage(url14.getUrl());

                // Saving all properties after adding everything

                propertyRepository.save(property1);
                propertyRepository.save(property2);
                propertyRepository.save(property3);
                propertyRepository.save(property4);
                propertyRepository.save(property5);
                propertyRepository.save(property6);
                propertyRepository.save(property7);
                propertyRepository.save(property8);
                propertyRepository.save(property9);
                propertyRepository.save(property10);
                propertyRepository.save(property11);
                propertyRepository.save(property12);
                propertyRepository.save(property13);
                propertyRepository.save(property14);

                //  Bookings

                Booking testBooking1 = new Booking(sushi, property1, "20-09-22", 7, 2);
                bookingRepository.save(testBooking1);

                Booking testBooking2 = new Booking(sushi, property2, "15-10-22", 3, 2);
                bookingRepository.save(testBooking2);

                Booking testBooking3 = new Booking(charlie, property3, "13-11-22", 7, 2);
                bookingRepository.save(testBooking3);

                Booking testBooking4 = new Booking(charlie, property4, "04-12-22", 3, 2);
                bookingRepository.save(testBooking4);

                Booking testBooking5 = new Booking(christine, property5, "20-01-23", 7, 2);
                bookingRepository.save(testBooking5);

                Booking testBooking6 = new Booking(christine, property6, "25-02-23", 3, 2);
                bookingRepository.save(testBooking6);

                Booking testBooking7 = new Booking(tracey, property7, "02-03-23", 7, 2);
                bookingRepository.save(testBooking7);

                Booking testBooking8 = new Booking(tracey, property8, "10-04-23", 3, 2);
                bookingRepository.save(testBooking8);

                Booking testBooking9 = new Booking(tracey, property10, "05-05-23", 3, 2);
                bookingRepository.save(testBooking9);

                Booking testBooking10 = new Booking(tracey, property11, "03-06-23", 4, 2);
                bookingRepository.save(testBooking10);

                Booking testBooking11 = new Booking(tracey, property12, "20-07-23", 3, 2);
                bookingRepository.save(testBooking11);

                Booking testBooking12 = new Booking(tracey, property13, "02-09-22", 7, 4);
                bookingRepository.save(testBooking12);

                Booking testBooking13 = new Booking(charlie, property14, "20-09-22", 4, 4);
                bookingRepository.save(testBooking13);

                Booking testBooking14 = new Booking(charlie, property1, "13-09-22", 3, 2);
                bookingRepository.save(testBooking14);

                Booking testBooking15 = new Booking(charlie, property1, "23-09-22", 4, 2);
                bookingRepository.save(testBooking15);

                Booking testBooking16 = new Booking(sushi, property1, "21-09-22", 7, 2);
                bookingRepository.save(testBooking16);

                //  Reviews

                Review testReview1 = new Review("Lorem ipsum dolor sit amet. Eos delectus recusandae et quibusdam consequuntur non quia modi qui sunt autem ut officia corporis. Et dolorum laboriosam harum inventore 33 voluptatum rerum", 10F, sushi, property1);
                reviewRepository.save(testReview1);

                Review testReview2 = new Review("Aut sunt eligendi voluptatum odit est autem impedit ut blanditiis nihil aut repellendus Quis! Ut internos velit eum dicta quis qui debitis officiis et autem earum sed voluptatem inventore eos nostrum ducimus!", 10F, sushi, property2);
                reviewRepository.save(testReview2);

                Review testReview3 = new Review("Et beatae sint nam recusandae quae sed quas dolorem ab voluptatem nihil sit neque quasi id maiores facere. Non aliquid culpa sed repellat voluptas ab quasi odit.", 10F, sushi, property3);
                reviewRepository.save(testReview3);

                Review testReview4 = new Review("Non accusantium sunt hic deleniti delectus sit optio omnis nam repellat molestias. Et magnam ullam et necessitatibus necessitatibus qui cumque sint ea esse adipisci aut tempore suscipit ut dolorem voluptatem et voluptates fugiat. Aut dolor laborum est autem asperiores et repellendus quae ad harum fugiat?", 10F, charlie, property4);
                reviewRepository.save(testReview4);

                Review testReview5 = new Review("In galisum voluptas sit dolor asperiores et natus velit et eligendi iste qui quia repellendus ut quia inventore ut quis quos? Et quod vero 33 dolore maiores qui nobis ipsum non Quis qui quia odit et laborum officiis et iusto totam.", 4F, sushi, property2);
                reviewRepository.save(testReview5);

                Review testReview6 = new Review("Est quis quaerat aut consequatur aliquam et reiciendis voluptas qui tenetur voluptate id nisi excepturi sit consequatur iste non quibusdam tenetur? Vel maiores velit sit galisum corporis et possimus ex earum iste non minus rerum quo quia vero est amet. Est reiciendis expedita et ipsum consequuntur ex reiciendis officia qui galisum consequuntur qui veritatis internos. Qui voluptatem repellat et ullam laboriosam et dolore neque.", 2F, sushi, property4);
                reviewRepository.save(testReview6);

                Review testReview7 = new Review("Lorem ipsum dolor sit amet. Eos delectus recusandae et quibusdam consequuntur non quia modi qui sunt autem ut officia corporis. Et dolorum laboriosam harum inventore 33 voluptatum rerum", 10F, tracey, property1);
                reviewRepository.save(testReview7);

                Review testReview8 = new Review("Aut sunt eligendi voluptatum odit est autem impedit ut blanditiis nihil aut repellendus Quis! Ut internos velit eum dicta quis qui debitis officiis et autem earum sed voluptatem inventore eos nostrum ducimus!", 10F, tracey, property2);
                reviewRepository.save(testReview8);

                Review testReview9 = new Review("Et beatae sint nam recusandae quae sed quas dolorem ab voluptatem nihil sit neque quasi id maiores facere. Non aliquid culpa sed repellat voluptas ab quasi odit.", 10F, tracey, property3);
                reviewRepository.save(testReview9);

                Review testReview10 = new Review("Non accusantium sunt hic deleniti delectus sit optio omnis nam repellat molestias. Et magnam ullam et necessitatibus necessitatibus qui cumque sint ea esse adipisci aut tempore suscipit ut dolorem voluptatem et voluptates fugiat. Aut dolor laborum est autem asperiores et repellendus quae ad harum fugiat?", 10F, sushi, property4);
                reviewRepository.save(testReview10);

                Review testReview11 = new Review("In galisum voluptas sit dolor asperiores et natus velit et eligendi iste qui quia repellendus ut quia inventore ut quis quos? Et quod vero 33 dolore maiores qui nobis ipsum non Quis qui quia odit et laborum officiis et iusto totam.", 4F, sushi, property2);
                reviewRepository.save(testReview11);

                Review testReview12 = new Review("Est quis quaerat aut consequatur aliquam et reiciendis voluptas qui tenetur voluptate id nisi excepturi sit consequatur iste non quibusdam tenetur? Vel maiores velit sit galisum corporis et possimus ex earum iste non minus rerum quo quia vero est amet. Est reiciendis expedita et ipsum consequuntur ex reiciendis officia qui galisum consequuntur qui veritatis internos. Qui voluptatem repellat et ullam laboriosam et dolore neque.", 2F, tracey, property4);
                reviewRepository.save(testReview12);


        }
}


