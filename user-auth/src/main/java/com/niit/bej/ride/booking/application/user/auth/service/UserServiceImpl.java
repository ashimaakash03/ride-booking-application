package com.niit.bej.ride.booking.application.user.auth.service;

import com.niit.bej.ride.booking.application.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserAlreadyExistsException;
import com.niit.bej.ride.booking.application.user.auth.exception.UserNotFoundException;
import com.niit.bej.ride.booking.application.user.auth.model.User;
import com.niit.bej.ride.booking.application.user.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerAUser(User user) throws UserAlreadyExistsException {
        Optional<User> optionalUser = this.userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User With ID: " + user.getId() + " already present");
        } else {
            return this.userRepository.save(user);
        }
    }

    @Override
    public boolean loginAUser(User user) throws InvalidCredentialsException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            if (userInDatabase.getEmail().equals(user.getEmail()) && userInDatabase.getPassword().equals(user.getPassword())) {
                return true;
            } else {
                throw new InvalidCredentialsException("Incorrect Email and Password");
            }
        } else {
            throw new UserNotFoundException("User With ID: " + user.getId() + " is not present");
        }
    }
}
