package com.niit.bej.ride.booking.app.booking.app.repository;

import com.niit.bej.ride.booking.app.booking.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findUserByName(String name);

    Optional<User> findUserByEmail(String email);
}
