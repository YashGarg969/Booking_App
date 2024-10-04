package com.example.Booking_App.service;

import com.example.Booking_App.domain.Train;
import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.TicketDto;
import com.example.Booking_App.repository.TicketRepository;
import com.example.Booking_App.repository.TrainRepository;
import com.example.Booking_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void bookTicket(TicketDto ticketDto) {

        Boolean trainExists = trainRepository.existsByTrainName(ticketDto.getTrainName());
        if (trainExists) {

            Integer numberOfSeats = trainRepository.getNumberOfSeats(ticketDto.getTrainName());
            if (numberOfSeats > 0) {
                ticketRepository.bookTicket(ticketDto);
            } else {
                throw new RuntimeException("Seats Not Available");
            }
        }
    }
}
