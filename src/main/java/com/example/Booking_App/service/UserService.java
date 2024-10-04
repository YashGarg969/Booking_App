package com.example.Booking_App.service;

import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.UserDto;
import com.example.Booking_App.exception.InvalidSignUpException;

public interface UserService {

    UserDto signUp(User user) throws InvalidSignUpException;

}
