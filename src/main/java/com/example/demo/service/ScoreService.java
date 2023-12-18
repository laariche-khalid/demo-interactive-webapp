package com.example.demo.service;

import com.example.demo.model.Match;
import com.example.demo.model.Score;

public interface ScoreService {

    Match getMatchById(Long matchId);
    
    Match startMatchById(Long matchId);

    Match endMatchById(Long matchId);

    boolean updateScore(Score scoreDTO);
}
