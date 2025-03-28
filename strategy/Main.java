package strategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<strategy.ReisOptie> opties = List.of(
                new strategy.ReisOptie("Auto", 50.0, 120, true),
                new strategy.ReisOptie("Trein", 30.0, 90, false),
                new strategy.ReisOptie("Bus", 20.0, 180, true)
        );

        strategy.ReisplannerService planner = new strategy.ReisplannerService(new strategy.GoedkoopsteStrategie());
        List<strategy.ReisOptie> gekozen = planner.filterReisopties(opties);

        System.out.println("Gekozen optie(s):");
        gekozen.forEach(optie -> System.out.println(optie));
    }
}