package com.example.Booking_App.controller;


import com.example.Booking_App.domain.Train;
import com.example.Booking_App.dto.ResponseDto;
import com.example.Booking_App.dto.TrainDto;
import com.example.Booking_App.repository.TrainRepository;
import com.example.Booking_App.service.TrainService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    public TrainService trainService;

    @Autowired
    public TrainRepository trainRepository;

    @GetMapping("/getTrains")
    public ResponseEntity<ResponseDto<?>> searchTrains(@RequestParam String startingPoint, @RequestParam String endingPoint)
    {
        return ResponseEntity.status(200)
                .body(new ResponseDto<>(trainService.getTrains(startingPoint,endingPoint),
                        true,
                        null,
                        HttpStatus.OK.value(),
                        null));
    }

    @PostMapping("/addTrain")
    public ResponseEntity<ResponseDto<String>> addTrain(@RequestBody TrainDto trainDto , HttpServletRequest request) throws Exception {
        try{

            trainService.addTrain(trainDto);
            return ResponseEntity.ok(new ResponseDto<>("Train saved successfully"
                    ,true,null
                    ,null,null));
        }catch (Exception e){
            return ResponseEntity.status(500)
                    .body(new ResponseDto<>("Could not save train",
                            false,
                            e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            request.getRequestURI()));
        }
    }

}
