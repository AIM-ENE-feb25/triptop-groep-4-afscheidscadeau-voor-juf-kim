package com.example.demo;

public interface State {
    void handle(Decider decider, boolean rooms);
}