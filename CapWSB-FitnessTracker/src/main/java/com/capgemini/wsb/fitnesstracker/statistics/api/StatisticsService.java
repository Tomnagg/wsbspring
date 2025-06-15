package com.capgemini.wsb.fitnesstracker.statistics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @SuppressWarnings("null")
    public Statistics createStatistics(StatisticsDto statisticsDto) {
        Statistics statistics = new Statistics();
        statistics.setUser(statisticsDto.getUserId());
        statistics.setTotalCaloriesBurned(statisticsDto.getTotalCaloriesBurned());
        statistics.setTotalTrainings(statisticsDto.getTotalTrainings());
        statistics.setTotalDistance(statisticsDto.getTotalDistance());
        return statisticsRepository.save(statistics);
    }

    @SuppressWarnings("null")
    public Statistics updateStatistics(Long id, StatisticsDto statisticsDto) {
        Optional<Statistics> optionalStatistics = statisticsRepository.findById(id);
        if (optionalStatistics.isPresent()) {
            Statistics statistics = optionalStatistics.get();
            statistics.setTotalCaloriesBurned(statisticsDto.getTotalCaloriesBurned());
            statistics.setTotalTrainings(statisticsDto.getTotalTrainings());
            statistics.setTotalDistance(statisticsDto.getTotalDistance());
            return statisticsRepository.save(statistics);
        } else {
            throw new RuntimeException("Statistics not found");
        }
    }

    @SuppressWarnings("null")
    public Statistics getStatisticsById(Long id) {
        return statisticsRepository.findById(id).orElseThrow(() -> new RuntimeException("Statistics not found"));
    }

    public void deleteStatistics(Long id) {
        statisticsRepository.deleteById(id);
    }

    public List<Statistics> findAllStatisticsByCaloriesGreaterThan(int calories) {
        return statisticsRepository.findByCaloriesGreaterThan(calories);
    }
}