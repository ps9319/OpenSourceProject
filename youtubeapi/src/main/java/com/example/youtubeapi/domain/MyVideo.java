package com.example.youtubeapi.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@SuperBuilder(toBuilder = true)
@Entity
public class MyVideo {
    public static final String ENTITY_PREFIX = "myVideo";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id")
    private Long id;
    @Column(name = ENTITY_PREFIX + "_title")
    private String title;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
}
