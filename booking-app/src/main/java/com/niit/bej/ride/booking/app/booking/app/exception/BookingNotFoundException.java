package com.niit.bej.ride.booking.app.booking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Booking Couldn't be Found", code = HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
