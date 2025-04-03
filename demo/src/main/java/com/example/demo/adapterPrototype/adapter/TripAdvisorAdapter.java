package com.example.demo.adapterPrototype.adapter;

import com.example.demo.adapterPrototype.api.TripAdvisorApi;
import com.example.demo.adapterPrototype.dto.AttractionDto;
import com.example.demo.adapterPrototype.dto.TripAdvisorAttractionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripAdvisorAdapter implements AttractionAdapter {
    private TripAdvisorApi tripAdvisorApi;

    public TripAdvisorAdapter(TripAdvisorApi tripAdvisorApi) {
        this.tripAdvisorApi = tripAdvisorApi;
    }

    @Override
    public List<AttractionDto> getAttractions(String location) {
        List<TripAdvisorAttractionDto> rawData = tripAdvisorApi.fetchAttractions(location);

        List<AttractionDto> attractions = new ArrayList<>();
        for (TripAdvisorAttractionDto item : rawData) {
            attractions.add(new AttractionDto(item.title(), item.address(), item.score(), item.provider()));
        }
        return attractions;
    }

    @Override
    public String getName() {
        return "TripAdvisor";
    }
}
