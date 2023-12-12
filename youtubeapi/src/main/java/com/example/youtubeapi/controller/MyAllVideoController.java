package com.example.youtubeapi.controller;

import com.example.youtubeapi.service.MyAllVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyAllVideoController {
    private final MyAllVideoService myAllVideoService;

    @GetMapping("/api/video")
    public void create() throws GeneralSecurityException, IOException {
        myAllVideoService.putAllVideo();
    }
}
