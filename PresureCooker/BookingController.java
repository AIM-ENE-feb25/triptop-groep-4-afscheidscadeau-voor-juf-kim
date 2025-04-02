import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@RestController
public class BookingController {
    
    private static final String API_KEY = "your_api_key_here";
    private static final String BASE_URL = "https://distribution-xml.booking.com/json/bookings.getAvailability";
    
    @GetMapping("/checkAvailability")
    public ResponseEntity<String> checkAvailability(
            @RequestParam String checkin,
            @RequestParam String checkout,
            @RequestParam String hotelId,
            @RequestParam String roomConfig) {
        
        String url = String.format("%s?checkin=%s&checkout=%s&hotel_ids=%s&room1=%s&currency=USD&guest_country=US", 
                BASE_URL, checkin, checkout, hotelId, roomConfig);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        
        return response;
    }
}
