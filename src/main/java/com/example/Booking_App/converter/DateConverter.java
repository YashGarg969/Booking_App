package com.example.Booking_App.converter;

import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateConverter implements AttributeConverter<Date,Long> {
    @Override
    public Long convertToDatabaseColumn(Date date) {
        if(date==null){
            throw new RuntimeException("Date cannot be null!");
        }

        return date.getTime();
    }

    @Override
    public Date convertToEntityAttribute(Long dateInLong) {
        if(dateInLong==null){
            throw new RuntimeException("Date cannot be null!");
        }

        return new Date(dateInLong);
    }

}