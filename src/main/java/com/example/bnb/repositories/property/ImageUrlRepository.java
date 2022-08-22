package com.example.bnb.repositories.property;

import com.example.bnb.models.property.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
}
