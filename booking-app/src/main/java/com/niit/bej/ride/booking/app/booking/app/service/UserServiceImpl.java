package com.niit.bej.ride.booking.app.booking.app.service;

import com.niit.bej.ride.booking.app.booking.app.exception.BookingNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.exception.EmptyBookingsListException;
import com.niit.bej.ride.booking.app.booking.app.exception.UserAlreadyCreatedException;
import com.niit.bej.ride.booking.app.booking.app.exception.UserNotFoundException;
import com.niit.bej.ride.booking.app.booking.app.model.Booking;
import com.niit.bej.ride.booking.app.booking.app.model.User;
import com.niit.bej.ride.booking.app.booking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(User user) throws UserAlreadyCreatedException {
        Optional<User> optionalUser = this.userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyCreatedException("User With ID: " + user.getId() + " already preesent");
        } else {
            return this.userRepository.save(user);
        }
    }

    @Override
    public User fetchUserByName(String name) throws UserNotFoundException {
        Optional<User> userByName = this.userRepository.findUserByName(name);
        if (userByName.isPresent()) {
            return userByName.get();
        } else {
            throw new UserNotFoundException("User With Name: " + name + " not found");
        }
    }

    @Override
    public User fetchUserByEmail(String email) throws UserNotFoundException {
        Optional<User> userByEmail = this.userRepository.findUserByEmail(email);
        if (userByEmail.isPresent()) {
            return userByEmail.get();
        } else {
            throw new UserNotFoundException("User With Email: " + email + " not found");
        }
    }

    @Override
    public Booking addNewBooking(int userId, Booking booking) throws UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            bookingsByTheUser.add(booking);
            return booking;
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " not found");
        }
    }

    @Override
    public List<Booking> viewAllBookingsOfUser(int userId) throws EmptyBookingsListException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            if (bookingsByTheUser.isEmpty()) {
                throw new EmptyBookingsListException("No Bookings Found for User with ID: " + userId);
            } else {
                return bookingsByTheUser;
            }
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " not found");
        }
    }

    @Override
    public Booking findSpecificBooking(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            if (bookingsByTheUser.contains(booking)) {
                return booking;
            } else {
                throw new BookingNotFoundException("Booking Could Not Be Found");
            }
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " couldn't be found");
        }
    }

    @Override
    public Booking updateABooking(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            if (bookingsByTheUser.contains(booking)) {
                booking.setPickupLocation(booking.getPickupLocation());
                booking.setDropLocation(booking.getDropLocation());
                booking.setTypeOfVehicle(booking.getTypeOfVehicle());

                return null; //doubt, please ask
            } else {
                throw new BookingNotFoundException("Booking Not Found In The List");
            }
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " not found");
        }
    }

    @Override
    public boolean deleteABookingOfUser(int userId, Booking booking) throws BookingNotFoundException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            if (bookingsByTheUser.contains(booking)) {
                bookingsByTheUser.remove(booking);
                return true;
            } else {
                throw new BookingNotFoundException("Booking Doesn't Exist");
            }
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " not found");
        }
    }

    @Override
    public boolean deleteAllBookingsOfUser(int userId) throws EmptyBookingsListException, UserNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userInDatabase = optionalUser.get();
            List<Booking> bookingsByTheUser = userInDatabase.getBookings();
            if (bookingsByTheUser.isEmpty()) {
                throw new EmptyBookingsListException("No Bookings Found For User With ID: " + userId);
            } else {
                bookingsByTheUser.clear();
                return true;
            }
        } else {
            throw new UserNotFoundException("User With ID: " + userId + " not found");
        }
    }
}
