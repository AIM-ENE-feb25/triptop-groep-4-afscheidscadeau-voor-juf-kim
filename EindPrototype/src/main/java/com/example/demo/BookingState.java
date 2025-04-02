package com.example.demo;

import java.util.Random;

public class BookingState implements State {
    @Override
    public void handle(Decider decider, boolean rooms) {
        Booking booking = new Booking();
        Random random = new Random();
        if (rooms == true) {
            booking.book();
            decider.setState(null);
        } else {
            System.out.println("No room available");
            decider.setState(new FindNewBookingState());
        }
    }
}