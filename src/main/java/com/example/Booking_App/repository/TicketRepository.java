package com.example.Booking_App.repository;

import com.example.Booking_App.domain.BookingDetails;
import com.example.Booking_App.dto.TicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<BookingDetails,Long> {

    Boolean bookTicket(TicketDto ticketDto);
}
