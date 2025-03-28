package strategy;

import java.util.List;

public interface SelectieStrategie {
    List<ReisOptie> selecteer(List<ReisOptie> opties);
}