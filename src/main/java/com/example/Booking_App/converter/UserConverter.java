package com.example.Booking_App.converter;

import com.example.Booking_App.config.ModelMapperConfig;
import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    ModelMapperConfig modelMapperConfig;

    public UserDto toDto(User user){

        UserDto userDto = modelMapperConfig.modelMapper()
                .map(user, UserDto.class);

        return userDto;
    }

}