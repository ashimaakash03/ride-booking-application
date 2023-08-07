package com.niit.bej.ride.booking.app.booking.app.service;

import com.niit.bej.ride.booking.app.booking.app.exception.BookingNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.exception.EmptyBookingsListException;
import com.niit.bej.ride.booking.app.booking.app.exception.UserAlreadyCreatedException;
import com.niit.bej.ride.booking.app.booking.app.exception.UserNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.model.Booking;
import com.niit.bej.ride.booking.app.booking.app.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(User user) throws UserAlreadyCreatedException;

    User fetchUserByName(String name) throws UserNotFoundException;

    User fetchUserByEmail(String email) throws UserNotFoundException;

    Booking addNewBooking(int userId, Booking booking) throws UserNotFoundException;

    List<Booking> viewAllBookingsOfUser(int userId) throws EmptyBookingsListException, UserNotFoundException;

    Booking findSpecificBooking(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException;

    Booking updateABooking(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException;

    boolean deleteABookingOfUser(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException;

    boolean deleteAllBookingsOfUser(int userId) throws EmptyBookingsListException, UserNotFoundException;
}
