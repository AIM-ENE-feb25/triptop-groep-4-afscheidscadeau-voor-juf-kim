package strategy;

import java.util.Comparator;
import java.util.List;

public class GoedkoopsteStrategie implements SelectieStrategie {
    @Override
    public List<ReisOptie> selecteer(List<ReisOptie> opties) {
        return opties.stream()
                .sorted(Comparator.comparing(ReisOptie::getPrijs))
                .limit(1)
                .toList();
    }
}
