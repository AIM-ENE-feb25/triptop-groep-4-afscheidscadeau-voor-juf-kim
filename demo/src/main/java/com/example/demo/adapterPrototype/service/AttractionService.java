package com.example.demo.adapterPrototype.service;

import com.example.demo.adapterPrototype.adapter.AttractionAdapter;
import com.example.demo.adapterPrototype.dto.AttractionDto;
import com.example.demo.adapterPrototype.dto.AttractionListDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionService {
    private List<AttractionAdapter> providers;

    public AttractionService(List<AttractionAdapter> providers) {
        this.providers = providers;
    }


    public AttractionListDto fetchAttractions(String location){
        List<AttractionDto> allAtractions = new ArrayList<>();

        for(AttractionAdapter provider : providers){
            System.out.println("API: " + provider.getName());
            List<AttractionDto> attractions = provider.getAttractions(location);

            for(AttractionDto attraction : attractions){
                allAtractions.add(new AttractionDto(
                        attraction.name(),
                        attraction.address(),
                        attraction.rating(),
                        attraction.provider()
                ));
            }
        }
        return new AttractionListDto(allAtractions);
    }
}
