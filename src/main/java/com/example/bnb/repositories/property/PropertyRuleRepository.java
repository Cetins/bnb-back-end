package com.example.bnb.repositories.property;

import com.example.bnb.models.property.PropertyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRuleRepository extends JpaRepository<PropertyRule, Long> {
}
