package com.niit.bej.ride.booking.app.booking.app.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

@Document(collection = "bookings")
public class User {
    @MongoId
    private int id;
    private String name;
    private String contact;
    private String email;
    private List<Booking> bookings;

    public User() {
    }
    public User(int id, String name, String contact, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.bookings = bookings;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(contact, user.contact) && Objects.equals(email, user.email) && Objects.equals(bookings, user.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contact, email, bookings);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
