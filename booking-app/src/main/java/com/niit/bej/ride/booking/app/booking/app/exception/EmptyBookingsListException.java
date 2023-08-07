package com.niit.bej.ride.booking.app.booking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Bookings List Empty", code = HttpStatus.NO_CONTENT)
public class EmptyBookingsListException extends Exception {
    public EmptyBookingsListException(String message) {
        super(message);
    }
}
