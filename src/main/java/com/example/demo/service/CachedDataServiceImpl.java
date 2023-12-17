package com.example.demo.service;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.Joueur;
import com.example.demo.model.Match;
import com.example.demo.model.Score;

import java.util.ArrayList;
import java.util.List;

@Service
public class CachedDataServiceImpl implements CachedDataService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CachedDataServiceImpl.class);

	private Match matchData;

    public CachedDataServiceImpl(){

       
        matchData = Match.builder().id(1)
        .bluePlayer(Joueur.builder().clubName("Club 1").name("Khalid").build())
        .redPlayer(Joueur.builder().clubName("Club 2").name("Fouad").build())
        .build();
        List<Score> scores = new ArrayList<>();
         for (int i = 0; i < 4; i++) {
            scores.add(Score.builder().ArbitreName("Arbitre"+1)
                           .blueScore(0)
                           .redScore(0)
                           .id(i)
                           .match(Match.builder().id(1).build())
                           .build());
        }
            matchData.setScores(scores);

    }
    @Override
    public Match getLiveMatchData() {
        log.info("Get live Match data called");
		return matchData;
    }

    @Override
    public void updateLiveScoreData(Score score) {
        if(score != null) {
			log.debug("Matche updating");
            matchData.getScores().stream()
                                 .filter(item-> item.equals(score))
                                 .forEachOrdered(a ->{ 
                                                a.setRedScore(score.getRedScore());
                                                a.setBlueScore(score.getBlueScore());
                                            });
		}
    }

}
