package com.StrategyPatternTripTop.StrategyPattern.strategy.strategy;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;

import java.util.Comparator;
import java.util.List;

public class SnelsteStrategieReisOptie implements ReisOptieSelectieStrategie {
    @Override
    public List<ReisOptieModel> selecteer(List<ReisOptieModel> opties) {
        return opties.stream()
                .sorted(Comparator.comparingInt(ReisOptieModel::getReistijd))
                .limit(1)
                .toList();
    }
}