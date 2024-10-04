package com.example.Booking_App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    T data;
    Boolean success;
    String errorMessage;
    Integer errorCode;
    String meta;
}
