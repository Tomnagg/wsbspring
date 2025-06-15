package com.capgemini.wsb.fitnesstracker.statistics.api;

public class StatisticsNotFoundException extends RuntimeException {
    public StatisticsNotFoundException(String message) {
        super(message);
    }
}
