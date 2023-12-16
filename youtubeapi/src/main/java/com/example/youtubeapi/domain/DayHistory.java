package com.example.youtubeapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
@Entity
public class DayHistory {
    public static final String ENTITY_PREFIX = "dayHistory";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id")
    private Long id;
    @Column(name = ENTITY_PREFIX + "_noun")
    private String noun;
    @Column(name = ENTITY_PREFIX + "_day")
    private LocalDate date;

    @Override
    public String toString() {
        return noun + " ";
    }
}
