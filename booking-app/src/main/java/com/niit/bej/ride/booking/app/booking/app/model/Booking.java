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

    public Booking() {
    }

    public Booking(int id, String pickupLocation, String dropLocation, float distanceInKM, String typeOfVehicle, float price) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distanceInKM = distanceInKM;
        this.typeOfVehicle = typeOfVehicle;
        this.price = price;
    }
}
