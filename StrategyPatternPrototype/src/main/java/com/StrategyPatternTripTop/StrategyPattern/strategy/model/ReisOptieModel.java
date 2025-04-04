package com.StrategyPatternTripTop.StrategyPattern.strategy.model;

public class ReisOptieModel {
    private String naam;
    private double prijs;
    private int reistijdInMinuten;
    private boolean beschikbaar;

    public ReisOptieModel(String naam, double prijs, int reistijdInMinuten, boolean beschikbaar) {
        this.naam = naam;
        this.prijs = prijs;
        this.reistijdInMinuten = reistijdInMinuten;
        this.beschikbaar = beschikbaar;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getReistijd() {
        return reistijdInMinuten;
    }

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return naam + " (€" + prijs + ", " + reistijdInMinuten + "min, " +
                (beschikbaar ? "beschikbaar" : "niet beschikbaar") + ")";
    }
}