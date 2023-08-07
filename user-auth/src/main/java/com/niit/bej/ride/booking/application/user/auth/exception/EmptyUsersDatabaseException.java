package com.niit.bej.ride.booking.application.user.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "No Users Present in Database", code = HttpStatus.NO_CONTENT)
public class EmptyUsersDatabaseException extends Exception {
    public EmptyUsersDatabaseException(String message) {
        super(message);
    }
}
