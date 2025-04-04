package com.StrategyPatternTripTop.StrategyPattern.strategy.demo;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;
import com.StrategyPatternTripTop.StrategyPattern.strategy.service.ReisOptieService;
import com.StrategyPatternTripTop.StrategyPattern.strategy.strategy.GoedkoopsteStrategieReisOptie;

import java.util.List;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        List<ReisOptieModel> opties = List.of(
                new ReisOptieModel("Auto", 50.0, 120, true),
                new ReisOptieModel("Trein", 30.0, 90, false),
                new ReisOptieModel("Bus", 20.0, 180, true)
        );

        ReisOptieService planner = new ReisOptieService(new GoedkoopsteStrategieReisOptie());
        List<ReisOptieModel> gekozen = planner.filterReisopties(opties);

        System.out.println("Gekozen optie:");
        gekozen.forEach(optie -> System.out.println(optie));
    }
}