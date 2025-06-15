package com.capgemini.wsb.fitnesstracker.Statistics.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsRepository;

import java.util.Optional;

public class StatisticsServiceTest {

    @Mock
    private StatisticsRepository statisticsRepository;

    @InjectMocks
    private StatisticsService statisticsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStatistics() {
        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setUserId(1L);
        statisticsDto.setTotalDistance(300);
        statisticsDto.setTotalTrainings(8000);
        statisticsDto.setTotalDistance(5);

        Statistics statistics = new Statistics();
        statistics.setId(1L);
        statistics.setUser(1L);
        statistics.setTotalCaloriesBurned(300);
        statistics.setTotalTrainings(8000);
        statistics.setTotalDistance(5);

        when(statisticsRepository.save(any(Statistics.class))).thenReturn(statistics);

        Statistics createdStatistics = statisticsService.createStatistics(statisticsDto);

        assertNotNull(createdStatistics);
        assertEquals(1L, createdStatistics.getId());
        assertEquals(300, createdStatistics.getTotalCaloriesBurned());
    }

    @Test
    public void testUpdateStatistics() {
        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setTotalDistance(500);
        statisticsDto.setTotalTrainings(8000);
        statisticsDto.setTotalDistance(6);

        Statistics existingStatistics = new Statistics();
        existingStatistics.setId(1L);
        existingStatistics.setUser(1L);
        existingStatistics.setTotalCaloriesBurned(500);
        existingStatistics.setTotalTrainings(8000);
        existingStatistics.setTotalDistance(5);

        when(statisticsRepository.findById(1L)).thenReturn(Optional.of(existingStatistics));
        when(statisticsRepository.save(any(Statistics.class))).thenReturn(existingStatistics);

        Statistics updatedStatistics = statisticsService.updateStatistics(1L, statisticsDto);

        assertNotNull(updatedStatistics);
        assertEquals(500, updatedStatistics.getTotalCaloriesBurned());
        assertEquals(8000, updatedStatistics.getTotalTrainings());
    }
}