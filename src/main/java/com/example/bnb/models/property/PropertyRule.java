package com.example.bnb.models.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "property_rules")
public class PropertyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_allowed")
    private Boolean isAllowed;

    @ManyToMany
    @JsonIgnoreProperties({"property_rules"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "properties",
            joinColumns = { @JoinColumn(
                    name = "property_rule_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "property_id",
                    nullable = false,
                    updatable = false
            )})
    private List<PropertyRule> properties;

    public PropertyRule(String title, Boolean isAllowed, List<PropertyRule> properties) {
        this.title = title;
        this.isAllowed = isAllowed;
        this.properties = properties;
    }

    public PropertyRule() {
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

    public Boolean getAllowed() {
        return isAllowed;
    }

    public void setAllowed(Boolean allowed) {
        isAllowed = allowed;
    }

    public List<PropertyRule> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyRule> properties) {
        this.properties = properties;
    }
}
