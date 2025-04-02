import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class BookingController {

    private static final String API_KEY = "your_rapidapi_key_here";
    private static final String BASE_URL = "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels";

    @GetMapping("/checkAvailability")
    public ResponseEntity<String> checkAvailability(
            @RequestParam String checkin,
            @RequestParam String checkout,
            @RequestParam String hotelId,
            @RequestParam String adults) {

        String url = String.format("%s?checkin=%s&checkout=%s&hotel_id=%s&adults=%s&currency=USD&country=US",
                BASE_URL, checkin, checkout, hotelId, adults);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", "booking-com15.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response;
    }
}
