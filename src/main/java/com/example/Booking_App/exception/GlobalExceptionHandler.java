package com.example.Booking_App.exception;

import com.example.Booking_App.utils.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidSignUpException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidSignUpException(HttpServletRequest httpServletRequest,
                                                                          InvalidSignUpException exception){

        ExceptionResponse error = new ExceptionResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setSuccess(false);
        error.setErrorMessage(exception.getMessage());
        error.setPath(httpServletRequest.getRequestURI());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(HttpServletRequest httpServletRequest,
                                                                       MethodArgumentNotValidException exception){

        ExceptionResponse error = new ExceptionResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setSuccess(false);

        Map<String, String> errorMessages = new HashMap<>();

        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach((e)->{
                    String fieldName = ((FieldError) e).getField();
                    String errorMessage = e.getDefaultMessage();

                    errorMessages.put(fieldName,errorMessage);
                });

        error.setErrorMessage(errorMessages);
        error.setPath(httpServletRequest.getRequestURI());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException(HttpServletRequest httpServletRequest,
                                                                                          HttpRequestMethodNotSupportedException exception){

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage("Method "+httpServletRequest.getMethod()+" not supported");
        error.setSuccess(false);
        error.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        error.setPath(httpServletRequest.getRequestURI());

        return new ResponseEntity<>(error,HttpStatus.METHOD_NOT_ALLOWED);
    }

}
