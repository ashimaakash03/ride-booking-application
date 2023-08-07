package com.niit.bej.ride.booking.application.user.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cab_users")
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "user_name", length = 40, nullable = false)
    private String name;
    @Column(name = "contact", length = 10, unique = true, nullable = false)
    private String contact;
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    @Column(name = "password", length = 25, unique = true, nullable = false)
    private String password;

    public User() {
    }

    public User(int id, String name, String contact, String email, String password) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }
}
