package com.example.Booking_App.exception;

public class InvalidSignUpException extends RuntimeException{

    public InvalidSignUpException() {
    }

    public InvalidSignUpException(String message) {
        super(message);
    }

    public InvalidSignUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSignUpException(Throwable cause) {
        super(cause);
    }

    public InvalidSignUpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
