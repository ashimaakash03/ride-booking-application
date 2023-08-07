package com.niit.bej.ride.booking.application.user.auth.service;

import com.niit.bej.ride.booking.application.user.auth.model.User;
import com.niit.bej.ride.booking.application.user.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerAUser(User user) {
        return null;
    }

    @Override
    public User loginAUser(User user) {
        return null;
    }
}
