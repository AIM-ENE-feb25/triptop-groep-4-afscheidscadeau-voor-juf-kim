package com.example.demo.API;


import org.springframework.stereotype.Component;

@Component
public class KLMAPI {

    public String retrieveRoutes(String currentLocation, String destination) {
        float duration = (float) (Math.random() * 15 + 1);
        float distance = (float) (Math.random() * 10000 + 500);


        boolean flightPossible = Math.random() < 0.5;

        if (!flightPossible) {
            return ("{"
                    + "\"error\": \"Flight not available for the selected destination.\""
                    + "}");
        } else {

        return ("{"
                + "\"airline\": \"KLM\","
                + "\"startLocation\": \"" + currentLocation + "\","
                + "\"endLocation\": \"" + destination + "\","
                + "\"ticketPrice\": 349.99,"
                + "\"cabinClass\": \"Business Class\","
                + "\"flightNumber\": \"KL987\","
                + "\"seat\": \"12A\","
                + "\"window\": true"
                + "\"pilot\": {"
                + "\"name\": \"Captain Jeroen Bakker\","
                + "\"employeeID\": \"KLM44567\""
                + "\"departureTime\": \"10:15\","
                + "\"arrivalTime\": \"14:45\","
                + "\"durationHr\": " + duration + ","
                + "\"distanceKm\": " + distance + ","
                + "\"departureGate\": \"D5\","
                + "\"arrivalGate\": \"A12\","
                + "\"aircraftType\": \"Boeing 787 Dreamliner\","
                + "\"atDeparture\": \"Sunny, 20°C\","
                + "\"atArrival\": \"Cloudy, 15°C\""
                + "\"passengerCount\": 180,"
                + "\"baggageAllowance\": \"1 checked bag + 1 carry-on\","
                + "\"paymentMethod\": \"Credit Card\","
                + "\"promoApplied\": \"FLY50\","
                + "\"ticketID\": \"TICKET-45632\","
                + "\"customerSupport\": \"+31208912345\","
                + "\"inFlightEntertainment\": \"Movies, Music, Wi-Fi\","
                + "\"realTimeTrackingURL\": \"https://klm.com/tracking/TICKET-45632\","
                + "\"carbonFootprint\": \"250kg CO2\","
                + "\"frequentFlyerMiles\": 1200,"
                + "\"nextAvailableFlightETA\": 6"
                + "}");
        }
    }
};
