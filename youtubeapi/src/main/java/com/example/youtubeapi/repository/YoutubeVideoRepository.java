package com.example.youtubeapi.repository;

import com.example.youtubeapi.domain.MyVideo;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface YoutubeVideoRepository extends JpaRepository<MyVideo, Long> {
    @Query("select v from MyVideo v where v.createdDate >= :startDate and v.createdDate <= :endDate")
    List<MyVideo> findByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
