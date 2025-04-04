package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Routes;
import com.example.demo.service.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/routes")
    public List<Routes> fetchRoutes(@RequestParam String currentLocation, @RequestParam String destination) {
        return travelService.fetchRoutes(currentLocation, destination);
    }
}