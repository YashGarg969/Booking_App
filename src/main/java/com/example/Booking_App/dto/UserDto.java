package com.example.Booking_App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String role;
    private Long createdOn;
    private Long lastModifiedOn;

}