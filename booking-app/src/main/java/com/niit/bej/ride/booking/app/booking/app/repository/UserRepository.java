package com.niit.bej.ride.booking.app.booking.app.repository;

import com.niit.bej.ride.booking.app.booking.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
