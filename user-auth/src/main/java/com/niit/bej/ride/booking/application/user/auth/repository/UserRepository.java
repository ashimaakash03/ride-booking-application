package com.niit.bej.ride.booking.application.user.auth.repository;

import com.niit.bej.ride.booking.application.user.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String password);
}
