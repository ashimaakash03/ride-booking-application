package com.niit.bej.ride.booking.app.booking.app.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "{/api/v1/rides/**}")
public class JwtFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletOutputStream responseOutputStream = response.getOutputStream();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            responseOutputStream.print("Please Check Authorization Header");
            responseOutputStream.close();
            return;
        } else {
            String jsonWebToken = authorizationHeader.substring("Bearer ".length());
            Claims claims = Jwts.parser().setSigningKey("password").parseClaimsJws(jsonWebToken).getBody();
            request.setAttribute("claims", claims);
            request.setAttribute("subject", claims.getSubject());
        }
        chain.doFilter(request, response);
    }
}
