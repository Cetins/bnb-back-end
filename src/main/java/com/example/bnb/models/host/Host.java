package com.example.bnb.models.host;

import com.example.bnb.models.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hosts")
public class Host extends User {
}
