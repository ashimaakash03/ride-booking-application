package com.niit.bej.ride.booking.application.user.auth.service;

import com.niit.bej.ride.booking.application.user.auth.model.User;

public interface UserService {
    User registerAUser(User user);

    User loginAUser(User user);
}
