package com.niit.bej.ride.booking.application.user.auth.security;

import com.niit.bej.ride.booking.application.user.auth.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
