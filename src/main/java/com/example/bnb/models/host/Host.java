package com.example.bnb.models.host;

import com.example.bnb.models.User;
import com.example.bnb.models.property.ImageUrl;
import com.example.bnb.models.property.Property;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "hosts")
public class Host extends User {

    @JsonIgnoreProperties({"host"})
    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<Property> properties;

    public Host(String firstName, String lastName, String email, String password, List<Property> properties) {
        super(firstName, lastName, email, password);
        this.properties = properties;
    }

    public Host() {}

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
