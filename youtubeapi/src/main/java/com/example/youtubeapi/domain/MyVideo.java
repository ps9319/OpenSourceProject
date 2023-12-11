package com.example.youtubeapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MyVideo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "videotitle")
    private String title;
    @Column(name = "videodate")
    private String date;
}
