package com.StrategyPatternTripTop.StrategyPattern.strategy.strategy;

import com.StrategyPatternTripTop.StrategyPattern.strategy.model.ReisOptieModel;

import java.util.List;

public interface ReisOptieSelectieStrategie {
    List<ReisOptieModel> selecteer(List<ReisOptieModel> opties);
}