package com.example.bnb.models.guest;

import com.example.bnb.models.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class Guest extends User {
}
