package bezienswaardigheden;

import java.util.ArrayList;
import java.util.List;

public class TripAdvisorApi {
    public List<TripadvisorAttraction> fetchAttractions(String location) {
        List<TripadvisorAttraction> attractions = new ArrayList<>();
        List<TripadvisorAttraction> validAttractions = new ArrayList<>();

        attractions.add(new TripadvisorAttraction("Een of ander restaurant", "Nederland, Nijmegen", 3.5));
        attractions.add(new TripadvisorAttraction("Een ander restaurant", "Nederland, Amsterdam", 4.6));

        for (TripadvisorAttraction attraction : attractions) {
            if (attraction.address().contains(location)) {
                validAttractions.add(attraction);
            }
        }
        return validAttractions;
    }
}
