package bezienswaardigheden;

import java.util.ArrayList;
import java.util.List;

public class BookingComApi {
    public List<BookingComAttraction> retrieveAttractions(String location) {
        List<BookingComAttraction> attractions = new ArrayList<>();
        List<BookingComAttraction> validAttractions = new ArrayList<>();
        attractions.add(new BookingComAttraction("Restaurant van booking", "Nederland, Utrecht", 4.9));
        attractions.add(new BookingComAttraction("Nog eeen Restaurant bookingcom", "Nijmegen, Maastricht", 3.4));

        for (BookingComAttraction attraction : attractions) {
            if(attraction.location().contains(location)) {
                validAttractions.add(attraction);
            }
        }

        return validAttractions;
    }
}
