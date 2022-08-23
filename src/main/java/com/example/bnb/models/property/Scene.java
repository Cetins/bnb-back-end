package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "scenes")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
//    @JsonBackReference(value = "scenes")
    @JsonIgnoreProperties({"scenes"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "property_scenes",
            joinColumns = { @JoinColumn(
                    name = "scene_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )})
    private List<Property> properties;

    public Scene(String title) {
        this.title = title;
        this.properties = new ArrayList<>();
    }

    public Scene() {
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) { this.properties.add(property); }
}
