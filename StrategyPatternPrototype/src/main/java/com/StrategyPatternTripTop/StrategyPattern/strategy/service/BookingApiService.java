package com.StrategyPatternTripTop.StrategyPattern.strategy.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BookingApiService {

    private static final String API_URL = "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates";
    private static final String API_KEY = "f3beb5ca6emshe75db10c4e9b74ep1589a7jsn3917ae8afc4e";
    private static final String API_HOST = "booking-com15.p.rapidapi.com";

    public String searchHotelsByCoordinates(double latitude, double longitude, String arrivalDate, String departureDate, Integer radius, Integer adults, String childrenAge, Integer roomQty, Integer priceMin, Integer priceMax, String units, Integer pageNumber, String temperatureUnit, String languageCode, String currencyCode, String location) throws Exception {
        StringBuilder uriBuilder = new StringBuilder(API_URL)
                .append("?latitude=").append(latitude)
                .append("&longitude=").append(longitude)
                .append("&arrival_date=").append(arrivalDate)
                .append("&departure_date=").append(departureDate);

        if (radius != null) uriBuilder.append("&radius=").append(radius);
        if (adults != null) uriBuilder.append("&adults=").append(adults);
        if (childrenAge != null) uriBuilder.append("&children_age=").append(childrenAge);
        if (roomQty != null) uriBuilder.append("&room_qty=").append(roomQty);
        if (priceMin != null) uriBuilder.append("&price_min=").append(priceMin);
        if (priceMax != null) uriBuilder.append("&price_max=").append(priceMax);
        if (units != null) uriBuilder.append("&units=").append(units);
        if (pageNumber != null) uriBuilder.append("&page_number=").append(pageNumber);
        if (temperatureUnit != null) uriBuilder.append("&temperature_unit=").append(temperatureUnit);
        if (languageCode != null) uriBuilder.append("&languagecode=").append(languageCode);
        if (currencyCode != null) uriBuilder.append("&currency_code=").append(currencyCode);
        if (location != null) uriBuilder.append("&location=").append(location);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uriBuilder.toString()))
                .header("x-rapidapi-key", API_KEY)
                .header("x-rapidapi-host", API_HOST)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
