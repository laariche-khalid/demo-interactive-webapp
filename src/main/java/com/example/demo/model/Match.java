package com.example.demo.model;

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
    private Joueur redPlayer;
    private Joueur bluePlayer;
    List<Score> scores =  new ArrayList();
}
