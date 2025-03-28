package bezienswaardigheden;

import java.util.List;

public interface AttractionAdapter {
    List<Attraction> getAttractions(String location);

    String getName();
}
