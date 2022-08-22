package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_shared")
    private Boolean isShared;

    @ManyToMany
    @JsonIgnoreProperties({"facilities"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_facilities",
            joinColumns = { @JoinColumn(
                    name = "facility_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Amenity> properties;

    public Facility(String title, Boolean isShared) {
        this.title = title;
        this.isShared = isShared;
        this.properties = new ArrayList<>();
    }

    public Facility() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getShared() {
        return isShared;
    }

    public void setShared(Boolean shared) {
        isShared = shared;
    }

    public List<Amenity> getProperties() {
        return properties;
    }

    public void setProperties(List<Amenity> properties) {
        this.properties = properties;
    }
}
