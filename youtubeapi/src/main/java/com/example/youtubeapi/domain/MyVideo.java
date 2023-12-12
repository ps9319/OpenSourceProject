package com.example.youtubeapi.domain;

import com.example.youtubeapi.common.BaseEntity;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@SuperBuilder(toBuilder = true)
@Entity
public class MyVideo extends BaseEntity {
    public static final String ENTITY_PREFIX = "myVideo";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id")
    private Long id;
    @Column(name = ENTITY_PREFIX + "_title")
    private String title;
}
