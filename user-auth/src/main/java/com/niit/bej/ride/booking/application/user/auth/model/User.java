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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
