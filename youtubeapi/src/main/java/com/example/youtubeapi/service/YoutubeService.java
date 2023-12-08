package com.example.youtubeapi.service;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.GeneralSecurityException;
import com.google.api.services.youtube.model.*;

import java.util.*;

//@Service
public class YoutubeService {

    // You need to set this value for your code to compile.
    // For example: ... DEVELOPER_KEY = "YOUR ACTUAL KEY";
    private static final String DEVELOPER_KEY = "AIzaSyB1HxarbXZMw_cCqIQuZqIaGxlrpXkd8j0";
    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Call function to create API service object. Define and
     * execute API request. Print API response.
     *
     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
     */

    public static void getAllVideo()
            throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Videos.List request = youtubeService.videos()
                .list("snippet");
        VideoListResponse response = request.setKey(DEVELOPER_KEY)
                .setChart("mostPopular")
                .setRegionCode("KR")
                .setMaxResults(50L)
                .execute();
    }
    public static void main(String[] args)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Videos.List request = youtubeService.videos()
                .list("snippet");
        VideoListResponse response = request.setKey(DEVELOPER_KEY)
                .setChart("mostPopular")
                .setRegionCode("KR")
                .setMaxResults(50L)
                .execute();

        ArrayList<Video> videos = (ArrayList<Video>) response.get("items");
        Iterator<Video> it = videos.iterator();
        int count = 1;
        while (it.hasNext()) {
            VideoSnippet videoInfo = (VideoSnippet)it.next().get("snippet");
            String videoTitle = videoInfo.getTitle();
            System.out.println(count + " = " + videoTitle);
            count++;
        }
    }
}
