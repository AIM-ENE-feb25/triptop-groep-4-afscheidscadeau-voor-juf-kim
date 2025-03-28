package strategy;

import java.util.List;

public class BeschikbaarheidStrategie implements strategy.SelectieStrategie {
    @Override
    public List<strategy.ReisOptie> selecteer(List<strategy.ReisOptie> opties) {
        return opties.stream()
                .filter(strategy.ReisOptie::isBeschikbaar)
                .toList();
    }
}