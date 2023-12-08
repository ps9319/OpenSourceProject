package com.example.youtubeapi.service;
import com.example.youtubeapi.controller.MyVideoController;
import com.example.youtubeapi.domain.MyVideo;
import com.example.youtubeapi.repository.YoutubeVideoRepository;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import com.google.api.services.youtube.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyAllVideoService {

    private final YoutubeService youtubeService;
    private final YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    public MyAllVideoService(YoutubeService youtubeService, YoutubeVideoRepository youtubeVideoRepository) {
        this.youtubeService = youtubeService;
        this.youtubeVideoRepository = youtubeVideoRepository;

    }

    public VideoListResponse getAllVideo()
            throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        YouTube youtubeServiceEx = youtubeService.getService();
        // Define and execute the API request
        YouTube.Videos.List request = youtubeServiceEx.videos()
                .list("snippet");

        VideoListResponse response = request.setKey(youtubeService.getDeveloperKey())
                .setChart("mostPopular")
                .setRegionCode("KR")
                .setMaxResults(50L)
                .execute();
        return response;
    }
    public void putAllVideo(VideoListResponse videoListResponse){
        ArrayList<Video> videos = (ArrayList<Video>) videoListResponse.get("items");
        Iterator<Video> it = videos.iterator();
        int count = 1;
        while (it.hasNext()) {
            VideoSnippet videoInfo = (VideoSnippet) it.next().get("snippet");
            String videoTitle = videoInfo.getTitle();
            //System.out.println(count + " = " + videoTitle);
            MyVideo myVideo = new MyVideo();
            myVideo.setTitle(videoTitle);
            myVideo.setId(Long.parseLong(String.valueOf(count)));
            myVideo.setDate("1");
            youtubeVideoRepository.save(myVideo);
            count++;
        }
    }
}
