package com.example.demo.service;

import com.example.demo.model.Match;
import com.example.demo.model.Score;

public interface CachedDataService {
    
    Match getLiveMatchData(Long matchId);

    Match startMatch(Long matchId);
    Match endtMatch(Long matchId);

	boolean updateLiveScoreData(Score Score);

}
