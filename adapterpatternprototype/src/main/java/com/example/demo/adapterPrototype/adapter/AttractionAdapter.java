package com.example.demo.adapterPrototype.adapter;

import com.example.demo.adapterPrototype.dto.AttractionDto;

import java.util.List;

public interface AttractionAdapter {
    List<AttractionDto> getAttractions(String location);

    String getName();
}

