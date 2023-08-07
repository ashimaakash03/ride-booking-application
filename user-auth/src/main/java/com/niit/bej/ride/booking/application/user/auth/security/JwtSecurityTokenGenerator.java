package com.niit.bej.ride.booking.application.user.auth.security;

import com.niit.bej.ride.booking.application.user.auth.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        return null;
    }
}
