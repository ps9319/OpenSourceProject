package com.example.youtubeapi.repository;

import com.example.youtubeapi.domain.MyVideo;

public interface YoutubeVideoRepository {
    MyVideo save(MyVideo myVideo);
}
