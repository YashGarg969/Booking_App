package com.example.Booking_App.controller;

import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.ResponseDto;
import com.example.Booking_App.dto.UserDto;
import com.example.Booking_App.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> signUp(@Valid @RequestBody User user){

        UserDto userDto = userService.signUp(user);
        ResponseDto response = new ResponseDto<>(userDto,true,null,null,null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }



}
