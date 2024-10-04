package com.example.Booking_App.utils;

import lombok.Data;

@Data
public class ExceptionResponse<T>{

    private int statusCode;
    private Boolean success;
    private T errorMessage;
    private String path;

}