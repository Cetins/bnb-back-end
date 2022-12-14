package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "amenities")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JsonBackReference(value = "amenities")
//    @JsonIgnoreProperties({"amenities"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_amenities",
            joinColumns = { @JoinColumn(
                    name = "amenity_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Amenity> properties;

    public Amenity(String category, String title) {
        this.category = category;
        this.title = title;
        this.properties = new ArrayList<>();
    }

    public Amenity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Amenity> getProperties() {
        return properties;
    }

    public void setProperties(List<Amenity> properties) {
        this.properties = properties;
    }
}
