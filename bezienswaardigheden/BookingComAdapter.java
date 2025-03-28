package bezienswaardigheden;

import java.util.ArrayList;
import java.util.List;

public class BookingComAdapter implements AttractionAdapter {
    private BookingComApi bookingComApi;

    public BookingComAdapter(BookingComApi bookingComApi) {
        this.bookingComApi = bookingComApi;
    }

    @Override
    public List<Attraction> getAttractions(String location) {
        List<BookingComAttraction> rawData = bookingComApi.retrieveAttractions(location);
        List<Attraction> attractions = new ArrayList<>();

        for (BookingComAttraction item : rawData) {
            attractions.add(new Attraction(item.name(), item.location(), item.rating()));
        }

        return attractions;
    }

    @Override
    public String getName() {
        return "BookingCom";
    }
}
