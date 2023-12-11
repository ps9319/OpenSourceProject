package com.example.youtubeapi.repository;

import com.example.youtubeapi.domain.MyVideo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;


@Repository
public class YoutubeVideoRepositoryImpl implements YoutubeVideoRepository{

    private final EntityManager em;

    public YoutubeVideoRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public MyVideo save(MyVideo myVideo) {
        em.persist(myVideo);
        return myVideo;
    }
}
