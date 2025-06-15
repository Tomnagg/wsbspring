package com.capgemini.wsb.fitnesstracker.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample statistics
        Statistics statistics1 = new Statistics();
        statistics1.setUser(1L);
        statistics1.setTotalCaloriesBurned(500);
        statistics1.setTotalTrainings(5500);
        statistics1.setTotalDistance(5);
        statisticsRepository.save(statistics1);

        Statistics statistics2 = new Statistics();
        statistics2.setUser(2L);
        statistics2.setTotalCaloriesBurned(300);
        statistics2.setTotalTrainings(2500);
        statistics2.setTotalDistance(3);
        statisticsRepository.save(statistics2);
    }
}