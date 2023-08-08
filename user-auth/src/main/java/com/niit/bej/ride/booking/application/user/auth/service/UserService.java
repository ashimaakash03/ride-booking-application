package com.niit.bej.ride.booking.application.user.auth.service;

import com.niit.bej.ride.booking.application.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserAlreadyExistsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserNotFoundException;
import com.niit.bej.ride.booking.application.user.auth.model.User;

public interface UserService {
    User registerUser(User user) throws UserAlreadyExistsException;

    boolean loginUser(User user) throws InvalidCredentialsException, UserNotFoundException;
}
