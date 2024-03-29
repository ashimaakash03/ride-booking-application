package com.niit.bej.ride.booking.app.booking.app.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public float getDistanceInKM() {
        return distanceInKM;
    }

    public void setDistanceInKM(float distanceInKM) {
        this.distanceInKM = distanceInKM;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Float.compare(distanceInKM, booking.distanceInKM) == 0 && Float.compare(price, booking.price) == 0 && Objects.equals(pickupLocation, booking.pickupLocation) && Objects.equals(dropLocation, booking.dropLocation) && Objects.equals(typeOfVehicle, booking.typeOfVehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pickupLocation, dropLocation, distanceInKM, typeOfVehicle, price);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", distanceInKM=" + distanceInKM +
                ", typeOfVehicle='" + typeOfVehicle + '\'' +
                ", price=" + price +
                '}';
    }
}
