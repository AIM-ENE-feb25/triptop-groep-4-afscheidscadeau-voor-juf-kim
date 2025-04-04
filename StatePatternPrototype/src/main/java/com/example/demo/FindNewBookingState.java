package com.example.demo;

public class FindNewBookingState implements State {
    @Override
    public void handle(Decider decider, boolean rooms) {
        FindNewBooking findNewBooking = new FindNewBooking();
        findNewBooking.bookingReplacement();
        decider.setState(null);
    }
}