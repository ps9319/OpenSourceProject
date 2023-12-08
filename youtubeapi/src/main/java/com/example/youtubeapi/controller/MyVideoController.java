package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.YoutubeServiceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyVideoController {

//    YoutubeService youtubeService;
//
//    @Autowired
//    public MyVideoController(YoutubeService youtubeService) {
//        this.youtubeService = youtubeService;
//    }

    YoutubeServiceEx youtubeServiceEx;
    @Autowired
    public MyVideoController(YoutubeServiceEx youtubeServiceEx) {
        this.youtubeServiceEx = youtubeServiceEx;
    }
}
