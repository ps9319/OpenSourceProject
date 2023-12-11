package com.example.youtubeapi.repository;

import com.example.youtubeapi.domain.MyVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoutubeVideoRepository extends JpaRepository<MyVideo, Long> {
}
