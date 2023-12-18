package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {
    private int id;
    private String CompetitionName;
    private Joueur redPlayer;
    private Joueur bluePlayer;
    private StatusMatch status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    List<Score> scores =  new ArrayList();
}
