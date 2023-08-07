package com.niit.bej.ride.booking.app.booking.app.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Booking {
    @MongoId
    private int id;
    private String pickupLocation;
    private String dropLocation;
    private float distanceInKM;
    private String typeOfVehicle;
    private float price;
}
