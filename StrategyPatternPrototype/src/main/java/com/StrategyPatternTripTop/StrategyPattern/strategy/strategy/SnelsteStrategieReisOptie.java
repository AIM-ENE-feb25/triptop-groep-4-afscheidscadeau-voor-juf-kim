package com.StrategyPatternTripTop.StrategyPattern.strategy.strategy;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SnelsteStrategieReisOptie implements ReisOptieSelectieStrategie {
    @Override
    public List<ReisOptieModel> selecteer(List<ReisOptieModel> opties) {
        return opties.stream()
                .filter(ReisOptieModel::isBeschikbaar)
                .sorted(Comparator.comparingInt(ReisOptieModel::getReistijdInMinuten))
                .collect(Collectors.toList());
    }
}