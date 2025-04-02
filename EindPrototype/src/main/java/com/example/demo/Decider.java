package com.example.demo;

public class Decider {
    private State state;

    public void start(boolean rooms) {
        setState(new BookingState());
        while (state != null) {
            state.handle(this, rooms);
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}