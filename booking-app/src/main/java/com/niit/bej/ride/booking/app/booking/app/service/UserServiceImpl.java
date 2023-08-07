package com.niit.bej.ride.booking.app.booking.app.service;

import com.niit.bej.ride.booking.app.booking.app.model.Booking;
import com.niit.bej.ride.booking.app.booking.app.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User createNewUser(User user) {
        return null;
    }

    @Override
    public User fetchUserByName(String name) {
        return null;
    }

    @Override
    public User fetchUserByEmail(String email) {
        return null;
    }

    @Override
    public Booking addNewBooking(Booking booking) {
        return null;
    }

    @Override
    public List<Booking> viewAllBookingsOfUser(int userId) {
        return null;
    }

    @Override
    public Booking findSpecificBooking(int userId, int bookingId) {
        return null;
    }

    @Override
    public Booking updateABooking(int userId, int bookingId, Booking booking) {
        return null;
    }

    @Override
    public boolean deleteABookingOfUser(int userId, int bookingId) {
        return false;
    }

    @Override
    public boolean deleteAllBookingsOfUser(int userId) {
        return false;
    }
}
