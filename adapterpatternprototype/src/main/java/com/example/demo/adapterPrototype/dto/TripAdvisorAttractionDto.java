package com.example.demo.adapterPrototype.dto;

public record TripAdvisorAttractionDto(String provider, String title,String address, double score){
    public TripAdvisorAttractionDto(String title, String address, double score){
        this("Tripadvisor", title, address, score);
    }
}
