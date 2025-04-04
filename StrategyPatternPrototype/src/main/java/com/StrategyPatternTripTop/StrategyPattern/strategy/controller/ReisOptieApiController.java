package com.StrategyPatternTripTop.StrategyPattern.strategy.controller;

import com.StrategyPatternTripTop.StrategyPattern.strategy.dto.FilterRequest;
import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;
import com.StrategyPatternTripTop.StrategyPattern.strategy.service.BookingApiService;
import com.StrategyPatternTripTop.StrategyPattern.strategy.service.ReisOptieService;
import com.StrategyPatternTripTop.StrategyPattern.strategy.strategy.BeschikbareReisoptieStrategie;
import com.StrategyPatternTripTop.StrategyPattern.strategy.strategy.GoedkoopsteStrategieReisOptie;
import com.StrategyPatternTripTop.StrategyPattern.strategy.strategy.SnelsteStrategieReisOptie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reisopties")
public class ReisOptieApiController {

    private final ReisOptieService service;
    private final BookingApiService bookingApiService;

    @Autowired
    public ReisOptieApiController(BookingApiService bookingApiService) {
        this.service = new ReisOptieService(new GoedkoopsteStrategieReisOptie()); // Default strategy
        this.bookingApiService = bookingApiService;
    }

    @PostMapping("/filter")
    public List<ReisOptieModel> filter(@RequestBody FilterRequest request) {
        switch (request.getStrategie()) {
            case "snelste":
                service.setStrategie(new SnelsteStrategieReisOptie());
                break;
            case "goedkoopste":
                service.setStrategie(new GoedkoopsteStrategieReisOptie());
                break;
            case "beschikbaar":
                service.setStrategie(new BeschikbareReisoptieStrategie());
                break;
            default:
                throw new IllegalArgumentException("Ongeldige strategie");
        }

        return service.filterReisopties(request.getReisopties());
    }

    @GetMapping("/searchHotels")
    public String searchHotels(@RequestParam double latitude, @RequestParam double longitude, @RequestParam String arrivalDate, @RequestParam String departureDate, @RequestParam(required = false) Integer radius, @RequestParam(required = false) Integer adults, @RequestParam(required = false) String childrenAge, @RequestParam(required = false) Integer roomQty, @RequestParam(required = false) Integer priceMin, @RequestParam(required = false) Integer priceMax, @RequestParam(required = false) String units, @RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) String temperatureUnit, @RequestParam(required = false) String languageCode, @RequestParam(required = false) String currencyCode, @RequestParam(required = false) String location) throws Exception {
        return bookingApiService.searchHotelsByCoordinates(latitude, longitude, arrivalDate, departureDate, radius, adults, childrenAge, roomQty, priceMin, priceMax, units, pageNumber, temperatureUnit, languageCode, currencyCode, location);
    }
}
