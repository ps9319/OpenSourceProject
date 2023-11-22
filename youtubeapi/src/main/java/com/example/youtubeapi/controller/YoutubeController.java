package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.YoutubeService;
import org.springframework.stereotype.Controller;

@Controller
public class YoutubeController {

    YoutubeService youtubeService;

    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }


}
