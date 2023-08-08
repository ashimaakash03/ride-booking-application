package com.niit.bej.ride.booking.app.booking.app.controller;

import com.niit.bej.ride.booking.app.booking.app.exception.BookingNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.exception.EmptyBookingsListException;
import com.niit.bej.ride.booking.app.booking.app.exception.UserNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.model.Booking;
import com.niit.bej.ride.booking.app.booking.app.model.User;
import com.niit.bej.ride.booking.app.booking.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<?> fetchUserByName(@PathVariable String name) {
        try {
            User userFetchedByName = this.userService.fetchUserByName(name);
            return new ResponseEntity<>(userFetchedByName, HttpStatus.FOUND);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<?> fetchUserByEmail(@PathVariable String email) {
        try {
            User userFetchedByEmail = this.userService.fetchUserByEmail(email);
            return new ResponseEntity<>(userFetchedByEmail, HttpStatus.FOUND);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add-booking/{userId}")
    public ResponseEntity<?> addBookingForUser(@PathVariable int userId, @RequestBody Booking booking) {
        try {
            Booking newlyAddedBooking = this.userService.addNewBooking(userId, booking);
            return new ResponseEntity<>(newlyAddedBooking, HttpStatus.CREATED);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/view-booking/{userId}/all")
    public ResponseEntity<?> viewAllBookingsOfUser(@PathVariable int userId) {
        try {
            List<Booking> allBookingsList = this.userService.viewAllBookingsOfUser(userId);
            return new ResponseEntity<>(allBookingsList, HttpStatus.FOUND);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyBookingsListException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/view-booking/{userId}")
    public ResponseEntity<?> viewSpecificBookingOfUser(@PathVariable int userId, @RequestBody Booking booking) {
        try {
            Booking searchedBooking = this.userService.findSpecificBooking(userId, booking);
            return new ResponseEntity<>(searchedBooking, HttpStatus.FOUND);
        } catch (UserNotFoundException | BookingNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-booking/{userId}")
    public ResponseEntity<?> updateBookingDetailsForUser(@PathVariable int userId, @RequestBody Booking booking) {
        try {
            Booking updatedBooking = this.userService.updateBooking(userId, booking);
            return new ResponseEntity<>(updatedBooking, HttpStatus.ACCEPTED);
        } catch (UserNotFoundException | BookingNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/booking/{userId}")
    public ResponseEntity<?> deleteSingleBookingOfUser(@PathVariable int userId, @RequestBody Booking booking) {
        try {
            boolean isBookingDeleted = this.userService.deleteBookingOfUser(userId, booking);
            return new ResponseEntity<>(isBookingDeleted, HttpStatus.OK);
        } catch (UserNotFoundException | BookingNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/all/{userId}")
    public ResponseEntity<?> deleteAllBookingsForUser(@PathVariable int userId) {
        try {
            boolean areAllBookingsDeleted = this.userService.deleteAllBookingsOfUser(userId);
            return new ResponseEntity<>(areAllBookingsDeleted, HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyBookingsListException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}
