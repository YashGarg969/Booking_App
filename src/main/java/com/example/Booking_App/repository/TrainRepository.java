package com.example.Booking_App.repository;

import com.example.Booking_App.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {

    @Query(value = "SELECT * from trains where startingPoint=:startPoint and destinationPoint=:destination ",nativeQuery = true)
    List<Train> findTrainsBetweenRoute(String startPoint, String destination);

    Boolean existsByTrainName(String trainName);

    @Query(value = "SELECT seatsAvailable from trains where trainName=:trainName",nativeQuery = true)
    Integer getNumberOfSeats(String trainName);

}
