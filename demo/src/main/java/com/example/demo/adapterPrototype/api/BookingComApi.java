package com.example.demo.adapterPrototype.api;

import com.example.demo.adapterPrototype.dto.BookingComAttractionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingComApi {
    public List<BookingComAttractionDto> retrieveAttractions(String location) {
        List<BookingComAttractionDto> attractions = new ArrayList<>();
        List<BookingComAttractionDto> validAttractions = new ArrayList<>();
        attractions.add(new BookingComAttractionDto("Restaurant van booking", "Nederland, Utrecht", 4.9));
        attractions.add(new BookingComAttractionDto("Nog eeen Restaurant bookingcom", "Nijmegen, Maastricht", 3.4));

        for (BookingComAttractionDto attraction : attractions) {
            if(attraction.location().contains(location)) {
                validAttractions.add(attraction);
            }
        }

        return validAttractions;
    }
}
