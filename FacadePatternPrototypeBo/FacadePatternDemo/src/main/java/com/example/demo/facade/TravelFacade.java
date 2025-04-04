package com.example.demo.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.API.KLMAPI;
import com.example.demo.API.NSAPI;
import com.example.demo.API.UberAPI;
import com.example.demo.model.Routes;

@Component
public class TravelFacade {

    private final NSAPI nsAPI;
    private final KLMAPI klmAPI;
    private final UberAPI uberAPI;

    public TravelFacade(NSAPI nsAPI, KLMAPI klmAPI, UberAPI uberAPI) {
        this.nsAPI = nsAPI;
        this.klmAPI = klmAPI;
        this.uberAPI = uberAPI;
    }

    public List<Routes> fetchRoutes(String currentLocation, String destination) {

        List<Routes> processedRoutes = new ArrayList<>();

        String nsAPIResponseString = nsAPI.retrieveRoutes(currentLocation, destination);
        if (!nsAPIResponseString.contains("error")) {
            

        String[] nsAPIResponseArray = nsAPIResponseString.replaceAll("[\" ]", "").split(",");
        String nsStartLocation = nsAPIResponseArray[1].split(":")[1].trim();
        String nsEndLocation = nsAPIResponseArray[2].split(":")[1].trim();
        String nsDuration = nsAPIResponseArray[3].split(":")[1].trim();
        String nsDistance = nsAPIResponseArray[4].split(":")[1].trim();

        processedRoutes.add(new Routes(nsStartLocation, nsEndLocation, nsDuration, nsDistance));

        }

        String uberAPIResponseString = uberAPI.retrieveRoutes(currentLocation, destination);
        if (!uberAPIResponseString.contains("error")) {
        String[] uberAPIResponseArray = uberAPIResponseString.replaceAll("[\" ]", "").split(",");

        String uberDistance = uberAPIResponseArray[24].split(":")[1].trim();
        String uberDuration = uberAPIResponseArray[25].split(":")[1].trim();
        String uberStartLocation = uberAPIResponseArray[26].split(":")[1].trim();
        String uberEndLocation = uberAPIResponseArray[27].split(":")[1].trim();

        processedRoutes.add(new Routes(uberStartLocation, uberEndLocation, uberDuration, uberDistance));

        }

        String klmAPIResponseString = klmAPI.retrieveRoutes(currentLocation, destination);
        if (!klmAPIResponseString.contains("error")) {
        String[] klmAPIResponseArray = klmAPIResponseString.replaceAll("[\" ]", "").split(",");

        String klmDistance = klmAPIResponseArray[11].split(":")[1].trim();
        String klmDuration = klmAPIResponseArray[10].split(":")[1].trim();
        String klmStartLocation = klmAPIResponseArray[1].split(":")[1].trim();
        String klmEndLocation = klmAPIResponseArray[2].split(":")[1].trim();

        processedRoutes.add(new Routes(klmStartLocation, klmEndLocation, klmDuration, klmDistance));

        }
        


        return processedRoutes;
    }
}
