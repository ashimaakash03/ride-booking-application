package com.niit.bej.ride.booking.application.user.auth.service;

import com.niit.bej.ride.booking.application.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserAlreadyExistsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserNotFoundException;
import com.niit.bej.ride.booking.application.user.auth.model.User;

public interface UserService {
    User registerAUser(User user) throws UserAlreadyExistsException;

    boolean loginAUser(User user) throws InvalidCredentialsException, UserNotFoundException;
}
