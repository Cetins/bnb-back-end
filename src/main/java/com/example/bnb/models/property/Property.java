package com.example.bnb.models.property;

import com.example.bnb.models.booking.Booking;
import com.example.bnb.models.host.Host;
import com.example.bnb.models.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"properties"})
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(name = "is_Active")
    private Boolean isActive;

    @Column(name = "type")
    private String type;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "location")
    private String location;

    @JsonIgnoreProperties({"property"})
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<ImageUrl> imageUrls;

    @ManyToMany
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "scenes",
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
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "facilities",
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
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "amenities",
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
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "parking_options",
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
    @JsonIgnoreProperties({"properties"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_rules",
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

    @JsonIgnoreProperties({"property"})
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Property(Host host, Boolean isActive, String type, Double rate, String location, List<ImageUrl> imageUrls, List<Scene> scenes, List<Facility> facilities, List<Amenity> amenities, List<Parking> parkingOptions, List<PropertyRule> propertyRules, String checkInAfter, String checkInBefore, String checkOutBefore, List<Review> reviews, List<Booking> bookings) {
        this.host = host;
        this.isActive = isActive;
        this.type = type;
        this.rate = rate;
        this.location = location;
        this.imageUrls = imageUrls;
        this.scenes = scenes;
        this.facilities = facilities;
        this.amenities = amenities;
        this.parkingOptions = parkingOptions;
        this.propertyRules = propertyRules;
        this.checkInAfter = checkInAfter;
        this.checkInBefore = checkInBefore;
        this.checkOutBefore = checkOutBefore;
        this.reviews = reviews;
        this.bookings = bookings;
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

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<Parking> getParkingOptions() {
        return parkingOptions;
    }

    public void setParkingOptions(List<Parking> parkingOptions) {
        this.parkingOptions = parkingOptions;
    }

    public List<PropertyRule> getPropertyRules() {
        return propertyRules;
    }

    public void setPropertyRules(List<PropertyRule> propertyRules) {
        this.propertyRules = propertyRules;
    }

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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
