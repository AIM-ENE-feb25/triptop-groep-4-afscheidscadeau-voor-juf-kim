package com.example.demo.API;

import org.springframework.stereotype.Component;

@Component
public class NSAPI {

    public String retrieveRoutes(String currentLocation, String destination)  {
        float duration = (float) (Math.random() * 10 + 1);
        float distance = (float) (Math.random() * 500 + 50);

        boolean trainPossible = Math.random() < 0.5;

        if (!trainPossible) {
            return ("{"
                    + "\"error\": \"Train service not available for the selected route.\""
                    + "}");
        } else {
        return ("{"
                + "\"trainService\": \"NSAPI\","
                + "\"startLocation\": \"" + currentLocation + "\","
                + "\"endLocation\": \"" + destination + "\","
                + "\"durationHr\": " + duration + ","
                + "\"distanceKm\": " + distance
                + ","
                + "\"ticketPrice\": 25.99,"
                + "\"class\": \"First Class\","
                + "\"trainNumber\": \"IC5678\","
                + "\"conductor\": "
                + "\"name\": \"Mark Van Dijk\","
                + "\"employeeID\": \"NS12345\""
                + ","
                + "\"departureTime\": \"14:30\","
                + "\"arrivalTime\": \"18:45\","
                + "\"platform\": \"7B\","
                + "\"trainType\": \"Intercity Express\","
                + "\"weatherConditions\": "
                + "\"atDeparture\": \"Cloudy, 18°C\","
                + "\"atArrival\": \"Rainy, 16°C\""
                + ","
                + "\"passengerCount\": 120,"
                + "\"paymentMethod\": \"Debit Card\","
                + "\"promoApplied\": \"SPRING20\","
                + "\"ticketID\": \"TICKET-78901\","
                + "\"customerSupport\": \"+310123456789\","
                + "\"luggagePolicy\": \"1 large suitcase + 1 carry-on\","
                + "\"realTimeTrackingURL\": \"https://nsapi.nl/tracking/TICKET-78901\","
                + "\"carbonFootprint\": \"12.5kg CO2\","
                + "\"loyaltyPoints\": 85,"
                + "\"nextAvailableTrainETA\": 10"
                + "}");
        }
    }
};
