package com.example.youtubeapi.service;

import com.example.youtubeapi.domain.MyVideo;
import com.example.youtubeapi.repository.YoutubeVideoRepository;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import com.google.api.services.youtube.model.*;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MyAllVideoService {

    private final YoutubeService youtubeService;
    private final YoutubeVideoRepository youtubeVideoRepository;

    private VideoListResponse getAllVideo()
            throws GeneralSecurityException, IOException {
        YouTube youtubeServiceEx = youtubeService.getService();

        YouTube.Videos.List request = youtubeServiceEx.videos()
                .list("snippet");

        return request.setKey(youtubeService.getDeveloperKey())
                .setChart("mostPopular")
                .setRegionCode("KR")
                .setMaxResults(50L)
                .execute();
    }

    public void putAllVideo() throws GeneralSecurityException, IOException {
        VideoListResponse videoListResponse = getAllVideo();
        ArrayList<Video> videos = (ArrayList<Video>) videoListResponse.get("items");
        Iterator<Video> it = videos.iterator();
        while (it.hasNext()) {
            VideoSnippet videoInfo = (VideoSnippet) it.next().get("snippet");
            String videoTitle = videoInfo.getTitle();

            MyVideo video = MyVideo.builder()
                    .title(videoTitle)
                    .build();
            youtubeVideoRepository.save(video);
        }
    }

    public List<MyVideo> getMyVideo(int year, int month, int day) {
        LocalDateTime startDate = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year, month, day + 1, 0, 0);

        return youtubeVideoRepository.findByDate(startDate, endDate);
    }
}
