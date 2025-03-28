package strategy;

import java.util.Comparator;
import java.util.List;

public class SnelsteStrategie implements SelectieStrategie {
    @Override
    public List<ReisOptie> selecteer(List<ReisOptie> opties) {
        return opties.stream()
                .sorted(Comparator.comparing(ReisOptie::getReistijd))
                .limit(1)
                .toList();
    }
}