package bezienswaardigheden;

import java.util.ArrayList;
import java.util.List;

public class TripAdvisorAdapter implements AttractionAdapter {
    private TripAdvisorApi tripAdvisorApi;

    public TripAdvisorAdapter(TripAdvisorApi tripAdvisorApi) {
        this.tripAdvisorApi = tripAdvisorApi;
    }

    @Override
    public List<Attraction> getAttractions(String location) {
        List<TripadvisorAttraction> rawData = tripAdvisorApi.fetchAttractions(location);

        List<Attraction> attractions = new ArrayList<>();
        for (TripadvisorAttraction item : rawData) {
            attractions.add(new Attraction(item.title(), item.address(), item.score()));
        }
        return attractions;
    }

    @Override
    public String getName() {
        return "TripAdvisor";
    }
}
