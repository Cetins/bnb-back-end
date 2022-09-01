package com.example.bnb.repositories.guest;

import com.example.bnb.models.guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
}
