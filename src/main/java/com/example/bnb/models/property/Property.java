package com.example.bnb.models.property;

import com.example.bnb.models.booking.Booking;
import com.example.bnb.models.host.Host;
import com.example.bnb.models.review.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JsonBackReference(value = "properties2")
    @JsonIgnoreProperties({"id", "email", "password", "properties"})
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(name = "is_Active")
    private Boolean isActive;

    @Column(name = "type")
    private String type;

    @Column(name = "bedCount")
    private Integer bedCount;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

//    @JsonBackReference(value = "properties3")
    @JsonIgnoreProperties({"property"})
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<ImageUrl> imageUrls;

    @ManyToMany
//    @JsonBackReference(value = "properties4")
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_scenes",
            joinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "scene_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Scene> scenes;

    @ManyToMany
//    @JsonBackReference(value = "properties5")
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_facilities",
            joinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "facility_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Facility> facilities;

    @ManyToMany
//    @JsonBackReference(value = "properties6")
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_amenities",
            joinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "amenity_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Amenity> amenities;

    @ManyToMany
//    @JsonBackReference(value = "properties7")
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_parking_options",
            joinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "parking_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Parking> parkingOptions;

    @ManyToMany
//    @JsonBackReference(value = "properties8")
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_rules_list",
            joinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_rule_id",
                    nullable = false,
                    updatable = false
            )})
    private List<PropertyRule> propertyRules;

    @Column(name = "check_in_after")
    private String checkInAfter;

    @Column(name = "check_in_before")
    private String checkInBefore;

    @Column(name = "check_out_before")
    private String checkOutBefore;

    @JsonIgnoreProperties({"property"})
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<Review> reviews;

//    @JsonBackReference(value = "propertyBookings")
    @JsonIgnoreProperties({"property"})
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Property(Host host, Boolean isActive, String type, Integer bedCount, Double rate, String location, String description, String checkInAfter, String checkInBefore, String checkOutBefore) {
        this.host = host;
        this.isActive = isActive;
        this.type = type;
        this.bedCount = bedCount;
        this.rate = rate;
        this.location = location;
        this.description = description;
        this.imageUrls = new ArrayList<>();
        this.scenes = new ArrayList<>();
        this.facilities = new ArrayList<>();
        this.amenities = new ArrayList<>();
        this.parkingOptions = new ArrayList<>();
        this.propertyRules = new ArrayList<>();
        this.checkInAfter = checkInAfter;
        this.checkInBefore = checkInBefore;
        this.checkOutBefore = checkOutBefore;
        this.reviews = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public Property() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public void addImageUrl(ImageUrl imageUrl) { this.imageUrls.add(imageUrl); }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public void addScene(Scene scene) { this.scenes.add(scene); }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public void addFacility(Facility facility) { this.facilities.add(facility); }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public void addAmenity(Amenity amenity) { this.amenities.add(amenity); }

    public List<Parking> getParkingOptions() {
        return parkingOptions;
    }

    public void setParkingOptions(List<Parking> parkingOptions) {
        this.parkingOptions = parkingOptions;
    }

    public void addParkingOption(Parking parking) { this.parkingOptions.add(parking); }

    public List<PropertyRule> getPropertyRules() {
        return propertyRules;
    }

    public void setPropertyRules(List<PropertyRule> propertyRules) {
        this.propertyRules = propertyRules;
    }

    public void addPropertyRule(PropertyRule propertyRule) { this.propertyRules.add(propertyRule); }

    public String getCheckInAfter() {
        return checkInAfter;
    }

    public void setCheckInAfter(String checkInAfter) {
        this.checkInAfter = checkInAfter;
    }

    public String getCheckInBefore() {
        return checkInBefore;
    }

    public void setCheckInBefore(String checkInBefore) {
        this.checkInBefore = checkInBefore;
    }

    public String getCheckOutBefore() {
        return checkOutBefore;
    }

    public void setCheckOutBefore(String checkOutBefore) {
        this.checkOutBefore = checkOutBefore;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) { this.reviews.add(review); }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking) { this.bookings.add(booking); }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
