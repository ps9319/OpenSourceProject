package com.example.youtubeapi.service;

import com.example.youtubeapi.domain.DayHistory;
import com.example.youtubeapi.domain.MyVideo;
import com.example.youtubeapi.repository.DayHistoryRepository;
import com.example.youtubeapi.support.Analysis;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DayHistoryService {
    private final DayHistoryRepository dayHistoryRepository;
    private final MyAllVideoService videoService;
    private final Analysis analysis;
    @Value("${file.path}")
    private String filePath;

    public void setDayHistory(int year, int month, int day) {
        List<MyVideo> videos = videoService.getMyVideo(year, month, day);

        List<String> nouns = videos.stream()
                .flatMap(video -> analysis.extractNoun(video).stream())
                .toList();

        for (String noun : nouns) {
            LocalDate date = LocalDate.of(year, month, day);
            DayHistory dayHistory = toDayHistory(noun, date);

            dayHistoryRepository.save(dayHistory);
        }
    }

    private DayHistory toDayHistory(String noun, LocalDate date) {
        return DayHistory.builder()
                .noun(noun)
                .date(date)
                .build();
    }

    public void getFile(int year, int month, int day) {
        File file = new File(filePath + year + month + day + ".txt");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(year + " 년 " + month + " 월 " + day + " 일 ");

            List<DayHistory> histories = getHistory(year, month, day);

            for (DayHistory history : histories) {
                writer.write(history.toString());
            }

            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("file 생성에 오류가 발생했습니다.");
        }
    }

    private List<DayHistory> getHistory(int year, int month, int day) {
        LocalDate startDate = LocalDate.of(year, month, day);
        return dayHistoryRepository.findDayHistoriesByDate(startDate);
    }
}
