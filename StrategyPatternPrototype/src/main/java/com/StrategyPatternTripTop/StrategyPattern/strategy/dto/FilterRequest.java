package com.StrategyPatternTripTop.StrategyPattern.strategy.dto;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;

import java.util.List;

public class FilterRequest {
    private String strategie;
    private List<ReisOptieModel> reisopties;

    public String getStrategie() {
        return strategie;
    }

    public void setStrategie(String strategie) {
        this.strategie = strategie;
    }

    public List<ReisOptieModel> getReisopties() {
        return reisopties;
    }

    public void setReisopties(List<ReisOptieModel> reisopties) {
        this.reisopties = reisopties;
    }
}
