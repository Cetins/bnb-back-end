package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_amenities")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_free")
    private Boolean isFree;

    @ManyToMany
    @JsonIgnoreProperties({"parking_options"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_parking_options",
            joinColumns = { @JoinColumn(
                    name = "parking_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Parking> properties;

    public Parking(String title, Boolean isFree) {
        this.title = title;
        this.isFree = isFree;
        this.properties = new ArrayList<>();
    }

    public Parking() {
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

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public List<Parking> getProperties() {
        return properties;
    }

    public void setProperties(List<Parking> properties) {
        this.properties = properties;
    }
}
