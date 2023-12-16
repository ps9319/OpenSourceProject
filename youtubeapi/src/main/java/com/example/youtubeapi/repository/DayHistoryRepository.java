package com.example.youtubeapi.repository;

import com.example.youtubeapi.domain.DayHistory;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayHistoryRepository extends JpaRepository<DayHistory, Long> {
    List<DayHistory> findDayHistoriesByDate(LocalDate date);
}
