package com.niit.bej.ride.booking.app.booking.app.filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter(urlPatterns = "/api/v1/rides/**")
public class JwtFilter extends HttpFilter {
}
