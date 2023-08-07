package com.niit.bej.ride.booking.app.booking.app.service;

import com.niit.bej.ride.booking.app.booking.app.model.Booking;
import com.niit.bej.ride.booking.app.booking.app.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(User user);

    User fetchUserByName(String name);

    User fetchUserByEmail(String email);

    Booking addNewBooking(Booking booking);

    List<Booking> viewAllBookingsOfUser(int userId);

    Booking findSpecificBooking(int userId, int bookingId);

    Booking updateABooking(int userId, int bookingId, Booking booking);

    boolean deleteABookingOfUser(int userId, int bookingId);

    boolean deleteAllBookingsOfUser(int userId);
}
