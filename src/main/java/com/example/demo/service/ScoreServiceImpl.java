package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Match;
import com.example.demo.model.Score;

@Service
public class ScoreServiceImpl implements ScoreService {

    // Injectez votre repository ScoreRepository ici (assurez-vous de créer le repository approprié)
    @Autowired
    CachedDataService cachedDataService;

    @Override
    public Match getMatchById(Long matchId) {
        return cachedDataService.getLiveMatchData( matchId);
    }

    @Override
    public boolean updateScore(Score score) {
         return cachedDataService.updateLiveScoreData( score); 
   }

    @Override
    public Match startMatchById(Long matchId) {
        return cachedDataService.startMatch( matchId);
     }

    @Override
    public Match endMatchById(Long matchId) {
        return cachedDataService.endtMatch( matchId);  
      }
}
