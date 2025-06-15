package com.capgemini.wsb.fitnesstracker.statistics.internal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsService;

import java.util.List;


@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping
    public ResponseEntity<Statistics> createStatistics(@RequestBody StatisticsDto statisticsDtO) {
        Statistics statistics = statisticsService.createStatistics(statisticsDtO);
        return ResponseEntity.ok(statistics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistics> updateStatistics(@PathVariable Long id, @RequestBody StatisticsDto statisticsDtO) {
        Statistics statistics = statisticsService.updateStatistics(id, statisticsDtO);
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistics> getStatisticsById(@PathVariable Long id) {
        Statistics statistics = statisticsService.getStatisticsById(id);
        return ResponseEntity.ok(statistics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStatistics(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Statistics>> findAllStatisticsByCaloriesGreaterThan(@RequestParam int calories) {
        List<Statistics> statisticsList = statisticsService.findAllStatisticsByCaloriesGreaterThan(calories);
        return ResponseEntity.ok(statisticsList);
    }
}