package strategy;

import java.util.List;

public class ReisplannerService {

    private strategy.SelectieStrategie strategie;

    public ReisplannerService(strategy.SelectieStrategie strategie) {
        this.strategie = strategie;
    }

    public void setStrategie(strategy.SelectieStrategie strategie) {
        this.strategie = strategie;
    }

    public List<strategy.ReisOptie> filterReisopties(List<strategy.ReisOptie> opties) {
        return strategie.selecteer(opties);
    }
}
