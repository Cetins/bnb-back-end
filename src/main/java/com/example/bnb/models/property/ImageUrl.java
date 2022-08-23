package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "image_urls")
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @ManyToOne
//    @JsonBackReference(value = "imageUrls")
    @JsonIgnoreProperties({"imageUrls"})
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    public ImageUrl(String url, Property property) {
        this.url = url;
        this.property = property;
    }

    public ImageUrl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
