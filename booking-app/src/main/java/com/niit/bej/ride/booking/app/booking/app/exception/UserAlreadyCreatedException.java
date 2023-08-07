package com.niit.bej.ride.booking.app.booking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User Already Created", code = HttpStatus.CONFLICT)
public class UserAlreadyCreatedException extends Exception {
    public UserAlreadyCreatedException(String message) {
        super(message);
    }
}
