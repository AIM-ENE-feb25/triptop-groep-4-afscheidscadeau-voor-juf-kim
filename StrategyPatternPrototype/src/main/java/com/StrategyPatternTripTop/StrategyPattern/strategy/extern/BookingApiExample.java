package com.StrategyPatternTripTop.StrategyPattern.strategy.extern;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookingApiExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?latitude=19.24232736426361&longitude=72.85841985686734&adults=1&children_age=0%2C17&room_qty=1&units=metric&page_number=1&temperature_unit=c&languagecode=en-us&currency_code=EUR&location=US"))
                .header("x-rapidapi-key", "f3beb5ca6emshe75db10c4e9b74ep1589a7jsn3917ae8afc4e")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
