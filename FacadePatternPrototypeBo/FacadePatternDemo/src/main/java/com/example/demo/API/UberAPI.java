package com.example.demo.API;

import org.springframework.stereotype.Component;

@Component
public class UberAPI {

    public String retrieveRoutes(String currentLocation, String destination) {
        float duration = (float) (Math.random() * 10 + 1);
        float distance = (float) (Math.random() * 100 + 1);

        return ("{"
                + "\"service\": \"Uber\","
                + "\"priceEstimate\": 47.25,"
                + "\"surgeMultiplier\": 1.5,"
                + "\"name\": \"John Doe\","
                + "\"rating\": 4.89,"
                + "\"phone\": \"+123456789\""
                + ","
                + "\"car\": "
                + "\"model\": \"Toyota Prius\","
                + "\"color\": \"Blue\","
                + "\"licensePlate\": \"ABC-1234\""
                + ","
                + "\"etaMinutes\": 5,"
                + "\"routePolyline\": \"encodedPolylineData\","
                + "\"trafficConditions\": \"Moderate\","
                + "\"atStart\": \"Sunny, 25°C\","
                + "\"atEnd\": \"Cloudy, 22°C\","
                + "\"passengerCount\": 1,"
                + "\"paymentMethod\": \"Credit Card\","
                + "\"promoApplied\": \"SUMMER10\","
                + "\"serviceType\": \"UberX\","
                + "\"tripID\": \"TRIP-98765\","
                + "\"supportContact\": \"+18005551234\","
                + "\"pickup\": \"Meet at main entrance\","
                + "\"dropoff\": \"Ring doorbell upon arrival\","
                + "\"distanceKm\": " + distance + ","
                + "\"durationHr\": " + duration + ","
                + "\"startLocation\": \"" + currentLocation + "\","
                + "\"endLocation\": \"" + destination + "\","
                + "\"audioRecordingConsent\": \"Not Enabled\","
                + "\"realTimeTrackingURL\": \"https://uber.com/tracking/TRIP-98765\","
                + "\"estimatedCO2Emissions\": \"4.2kg\","
                + "\"userRideHistoryHash\": \"HASH-ABCDE12345\","
                + "\"deviceLocationPermission\": \"Granted\","
                + "\"userLoyaltyPoints\": 250,"
                + "\"nearestAvailableCarETA\": 3"
                + "}");
    }
}
