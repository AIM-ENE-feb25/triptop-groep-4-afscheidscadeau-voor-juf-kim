package com.example.demo.adapterPrototype.dto;

public record TripAdvisorAttractionDto(String title, String address, double score, String provider){
    public TripAdvisorAttractionDto(String title, String address, double score){
        this(title, address, score, "Tripadvisor");
    }
}
