package com.example.demo.model;

import org.springframework.context.annotation.Bean;

public class Routes {
    private String startLocation;
    private String endLocation;
    private String travelTime;
    private String travelDistance;

    public Routes(String startLocation, String endLocation, String travelTime, String travelDistance) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.travelTime = travelTime;
        this.travelDistance = travelDistance;
    }

    public String getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
    public String getEndLocation() {
        return endLocation;
    }
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
    public String getTravelTime() {
        return travelTime;
    }
    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }
    public String getTravelDistance() {
        return travelDistance;
    }
    public void setTravelDistance(String travelDistance) {
        this.travelDistance = travelDistance;
    }
    

    @Override
    public String toString() {
        return "Route from " + startLocation + " to " + endLocation + " | Time: " + travelTime + " | Distance: " + travelDistance;
    }
}
