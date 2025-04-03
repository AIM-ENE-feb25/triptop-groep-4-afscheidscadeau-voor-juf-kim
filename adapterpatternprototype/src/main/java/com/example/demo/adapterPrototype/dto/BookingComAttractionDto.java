package com.example.demo.adapterPrototype.dto;

public record BookingComAttractionDto(String name, String location, double rating, String provider) {
    public BookingComAttractionDto(String name, String location, double rating) {
        this(name, location, rating, "BookingCom");
    }
}
