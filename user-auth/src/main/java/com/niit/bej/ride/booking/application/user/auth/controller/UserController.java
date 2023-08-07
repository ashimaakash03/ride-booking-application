package com.niit.bej.ride.booking.application.user.auth.controller;

import com.niit.bej.ride.booking.application.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserAlreadyExistsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserNotFoundException;
import com.niit.bej.ride.booking.application.user.auth.model.User;
import com.niit.bej.ride.booking.application.user.auth.security.SecurityTokenGenerator;
import com.niit.bej.ride.booking.application.user.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private final SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerANewUser(@RequestBody User user) {
        try {
            User newlyRegisteredUser = this.userService.registerAUser(user);
            return new ResponseEntity<>(newlyRegisteredUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginExistingUser(@RequestBody User user) {
        try {
            boolean isUserLoggedIn = this.userService.loginAUser(user);
            if (isUserLoggedIn) {
                Map<String, String> generatedToken = this.securityTokenGenerator.generateToken(user);
                return new ResponseEntity<>(generatedToken, HttpStatus.OK);
            } else {
                throw new InvalidCredentialsException("Email and Password Mismatch");
            }
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InvalidCredentialsException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
