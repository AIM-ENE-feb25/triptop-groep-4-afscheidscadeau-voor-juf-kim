package com.example.demo;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BookingController {

    private static final String API_KEY = "dd7aafeeffmsh845f5792bbe9d2dp1fab68jsn725d7a8060b8";
    private static final String BASE_URL = "https://booking-com15.p.rapidapi.com/api/v1/hotels/getAvailability";

    @GetMapping("/checkAvailability")
    public String checkAvailability(
            @RequestParam String hotelId,
            @RequestParam String checkin,
            @RequestParam String checkout) {
        Decider decider = new Decider();

        String url = String.format("%s?hotel_id=%s&min_date=%s&max_date=%s&currency_code=USD&location=US",
                BASE_URL, hotelId, checkin, checkout);

        try {
            HttpResponse<String> response = Unirest.get(url)
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .asString();

            JSONObject jsonObject = new JSONObject(response.getBody());
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray avDates = data.getJSONArray("avDates");

            if (avDates == null || avDates.length() == 0) {
                decider.start(false);
                return "No availability found";

            }
            decider.start(true);
            return avDates.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Internal Server Error: " + e.getMessage();
        }
    }
}