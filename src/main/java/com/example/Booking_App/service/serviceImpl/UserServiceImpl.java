package com.example.Booking_App.service.serviceImpl;

import com.example.Booking_App.converter.UserConverter;
import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.UserDto;
import com.example.Booking_App.exception.InvalidSignUpException;
import com.example.Booking_App.repository.UserRepository;
import com.example.Booking_App.service.UserService;

import com.example.Booking_App.utils.AppConstants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    @Transactional
    public UserDto signUp(User user) throws InvalidSignUpException{

        if(userRepository.existsByUsername(user.getUsername())){
            throw new InvalidSignUpException(
                    "User with username "+"'"+user.getUsername()+"'"+" already exists"
            );

        }
        else if(!(user.getRole().equalsIgnoreCase("ADMIN") ||
                user.getRole().equalsIgnoreCase("GUEST"))){

            throw new InvalidSignUpException(AppConstants.DUPLICATE_USERNAME_EXCEPTION);
        }

        if(user.getPassword()
                .equals(user.getConfirmPassword())) {

            userRepository.save(user);
            UserDto userDto = userConverter.toDto(user);
            return userDto;
        }

        throw new InvalidSignUpException(AppConstants.PASSWORD_MISMATCH_EXCEPTION);
    }




}