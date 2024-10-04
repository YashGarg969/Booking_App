package com.example.Booking_App.service;


import com.example.Booking_App.domain.Train;
import com.example.Booking_App.dto.TrainDto;
import com.example.Booking_App.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    public final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<TrainDto> getTrains(String startPoint, String destination)
    {
        List<Train> availabeTrains = trainRepository.findTrainsBetweenRoute(startPoint,destination);
        List<TrainDto> trainDtoList = new ArrayList<>();
        for(Train train : availabeTrains){
            TrainDto trainDto = new TrainDto();
            trainDto.setTrainName(train.getTrainName());
            trainDto.setDestinationPoint(train.getDestinationPoint());
            trainDto.setNoOfSeats(train.getNoOfSeats());
            trainDto.setSeatsAvailable(train.getSeatsAvailable());
            trainDto.setStartingPoint(train.getStartingPoint());
            trainDtoList.add(trainDto);
        }

        return trainDtoList;
    }

    @Transactional
    public void addTrain(TrainDto trainDto) throws Exception {
        try
        {
            Train train= new Train();
            if(!trainRepository.existsByTrainName(trainDto.getTrainName())) {
                train.setTrainName(trainDto.getTrainName());
                train.setStartingPoint(trainDto.getStartingPoint());
                train.setDestinationPoint(trainDto.getDestinationPoint());
                train.setSeatsAvailable(trainDto.getSeatsAvailable());
                train.setNoOfSeats(trainDto.getNoOfSeats());
                trainRepository.save(train);
            }
            else{
                throw new RuntimeException("Train with name : "+trainDto.getTrainName()+" already exists");
            }
        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION : "+e.getMessage());
        }
    }




}
