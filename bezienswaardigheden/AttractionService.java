package bezienswaardigheden;

import java.util.ArrayList;
import java.util.List;

public class AttractionService {
    private List<AttractionAdapter> providers;

    public AttractionService(List<AttractionAdapter> providers) {
        this.providers = providers;
    }


    public void fetchAttractions(String location){
        for(AttractionAdapter provider : providers){
            System.out.println("API: " + provider.getName());
            List<Attraction> attractions = provider.getAttractions(location);
            for(Attraction attraction : attractions){
                System.out.println(attraction);
            }
        }
    }

}
