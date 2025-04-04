package com.StrategyPatternTripTop.StrategyPattern.strategy.strategy;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;

import java.util.List;

public class BeschikbareReisoptieStrategie implements ReisOptieSelectieStrategie {
    @Override
    public List<ReisOptieModel> selecteer(List<ReisOptieModel> opties) {
        return opties.stream()
                .filter(ReisOptieModel::isBeschikbaar)
                .toList();
    }
}