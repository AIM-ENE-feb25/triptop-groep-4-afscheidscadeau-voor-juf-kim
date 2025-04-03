package com.example.demo.adapterPrototype.api;

import com.example.demo.adapterPrototype.dto.TripAdvisorAttractionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripAdvisorApi {
    public List<TripAdvisorAttractionDto> fetchAttractions(String location) {
        List<TripAdvisorAttractionDto> attractions = new ArrayList<>();
        List<TripAdvisorAttractionDto> validAttractions = new ArrayList<>();

        attractions.add(new TripAdvisorAttractionDto("Een of ander restaurant", "Nederland, Nijmegen", 3.5));
        attractions.add(new TripAdvisorAttractionDto("Een ander restaurant", "Nederland, Amsterdam", 4.6));

        for (TripAdvisorAttractionDto attraction : attractions) {
            if (attraction.address().contains(location)) {
                validAttractions.add(attraction);
            }
        }
        return validAttractions;
    }
}
