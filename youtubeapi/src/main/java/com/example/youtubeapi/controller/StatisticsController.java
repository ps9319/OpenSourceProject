package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.DayHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatisticsController {
    private final DayHistoryService dayHistoryService;

    @PostMapping("/api/statistics")
    public void create(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day){
        dayHistoryService.setDayHistory(year, month, day);
    }

    @PostMapping("/api/statistics/file")
    public void createFile(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day){
        dayHistoryService.getFile(year, month, day);
    }
}
