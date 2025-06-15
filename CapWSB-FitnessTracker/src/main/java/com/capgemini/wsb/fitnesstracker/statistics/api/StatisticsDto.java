package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.user.api.User;

public class StatisticsDto {

    private long id;
    private long userId;
    private int totalTrainings;
    private double totalDistance;
    private int TotalCaloriesBurned;


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTotalTrainings() {
        return totalTrainings;
    }

    public void setTotalTrainings(int calories) {
        this.totalTrainings = calories;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int steps) {
        this.totalDistance = steps;
    }

    public int getTotalCaloriesBurned() {
        return TotalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(int distance) {
        this.TotalCaloriesBurned = distance;
    }
}