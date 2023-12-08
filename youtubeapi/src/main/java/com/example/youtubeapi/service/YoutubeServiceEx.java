package com.example.youtubeapi.service;

import com.example.youtubeapi.domain.MyVideo;
import com.example.youtubeapi.repository.YoutubeVideoRepository;
import com.example.youtubeapi.repository.YoutubeVideoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class YoutubeServiceEx {
    private final YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    public YoutubeServiceEx(YoutubeVideoRepository youtubeVideoRepository) {
        this.youtubeVideoRepository = youtubeVideoRepository;
    }

    public Long put(MyVideo myVideo){
        youtubeVideoRepository.save(myVideo);
        return myVideo.getId();
    }
}
