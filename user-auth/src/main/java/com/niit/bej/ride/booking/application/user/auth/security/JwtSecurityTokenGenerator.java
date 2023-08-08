package com.niit.bej.ride.booking.application.user.auth.security;

import com.niit.bej.ride.booking.application.user.auth.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = Jwts
                .builder()
                .setIssuedAt(new Date())
                .setSubject(user.getName())
                .signWith(SignatureAlgorithm.HS256, "password")
                .compact();
        return Map.of("token", jwtToken,
                "message", user.getName() + " logged in!");
    }
}
