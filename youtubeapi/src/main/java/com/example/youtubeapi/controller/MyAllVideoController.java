package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.MyAllVideoService;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
public class MyAllVideoController {
    private final MyAllVideoService myAllVideoService;

    public MyAllVideoController(MyAllVideoService myAllVideoService) {
        this.myAllVideoService = myAllVideoService;
    }

    public void create()
            throws GeneralSecurityException, IOException {
        myAllVideoService.putAllVideo(myAllVideoService.getAllVideo());
    }

}
