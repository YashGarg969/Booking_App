package com.example.Booking_App.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tickets")
public class BookingController {

    @PostMapping("/bookTicket")
    public void bookTicket()
    {

    }
}
