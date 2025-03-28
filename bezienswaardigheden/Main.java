package bezienswaardigheden;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TripAdvisorApi tripAdvisorApi = new TripAdvisorApi();
        BookingComApi bookingComApi = new BookingComApi();

        AttractionAdapter tripAdvisorAdapter = new TripAdvisorAdapter(tripAdvisorApi);
        AttractionAdapter bookingComAdapter = new BookingComAdapter(bookingComApi);

        AttractionService service = new AttractionService(List.of(tripAdvisorAdapter, bookingComAdapter));

        service.fetchAttractions("Nijmegen");
    }
}