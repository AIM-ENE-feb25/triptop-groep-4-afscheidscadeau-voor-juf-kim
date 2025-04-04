package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.facade.TravelFacade;
import com.example.demo.model.Routes;

@Service
public class TravelService {
    private final TravelFacade travelFacade;

    public TravelService(TravelFacade travelFacade) {
        this.travelFacade = travelFacade;
    }

    public List<Routes> fetchRoutes(String currentLocation, String destination) {
        // zou evt coole dingen met de data kunnen doen
        return travelFacade.fetchRoutes(currentLocation, destination);
    }
}
