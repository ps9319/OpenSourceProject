package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.MyAllVideoService;
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
