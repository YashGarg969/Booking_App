package com.example.Booking_App.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainName;
    private String startingPoint;
    private String destinationPoint;
    private Integer noOfSeats;
    private Integer seatsAvailable;

    @OneToMany(mappedBy = "train",
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingDetails> bookingDetails = new ArrayList<>();

}