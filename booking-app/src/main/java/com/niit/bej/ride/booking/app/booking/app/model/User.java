package com.niit.bej.ride.booking.app.booking.app.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "bookings")
public class User {
    @MongoId
    private int id;
    private String name;
    private String email;
    private List<Booking> bookings;
}
