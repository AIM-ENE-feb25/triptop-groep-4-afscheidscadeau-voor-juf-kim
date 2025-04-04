package com.StrategyPatternTripTop.StrategyPattern.strategy.service;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;
import com.StrategyPatternTripTop.StrategyPattern.strategy.strategy.ReisOptieSelectieStrategie;

import java.util.List;

public class ReisOptieService {

    private ReisOptieSelectieStrategie strategie;

    public ReisOptieService(ReisOptieSelectieStrategie strategie) {
        this.strategie = strategie;
    }

    public void setStrategie(ReisOptieSelectieStrategie strategie) {
        this.strategie = strategie;
    }

    public List<ReisOptieModel> filterReisopties(List<ReisOptieModel> opties) {
        return strategie.selecteer(opties);
    }
}
