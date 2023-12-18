package com.example.demo.service;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.stereotype.Service;

import com.example.demo.model.Joueur;
import com.example.demo.model.Match;
import com.example.demo.model.Score;
import com.example.demo.model.StatusMatch;
import java.time.temporal.TemporalUnit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CachedDataServiceImpl implements CachedDataService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CachedDataServiceImpl.class);

	private Match matchData;

    public CachedDataServiceImpl(){
        log.info("Initialistion des matches ...........");
        matchData = Match.builder().id(123)
        .bluePlayer(Joueur.builder().clubName("Club Karaté Bleu").name("Khalid").build())
        .redPlayer(Joueur.builder().clubName("Club Karaté Rouge").name("Fouad").build())
        .CompetitionName("Wosho Championship regional Rabat")
        .startTime(null)
        .status(StatusMatch.PROGRAMME)
        .build();
        List<Score> scores = new ArrayList<>();
         for (int i = 0; i < 5; i++) {
            scores.add(Score.builder().ArbitreName("Arbitre"+(i+1))
                           .blueScore(0)
                           .redScore(0)
                           .id(i)
                           .match(Match.builder().id(123).build())
                           .build());
        }
            matchData.setScores(scores);

    }
    @Override
    public Match getLiveMatchData(Long matchId) {
		return matchData;
    }

    @Override
    public boolean updateLiveScoreData(Score score) {
        if(score != null) {
            matchData.getScores().stream()
                                 .filter(item-> item.equals(score))
                                 .forEachOrdered(a ->{ 
                                                a.setRedScore(score.getRedScore());
                                                a.setBlueScore(score.getBlueScore());
                                                			log.info("Matche Updated OK ");
                                            });
            return true;
		}else{
            return false;
        }
    }
    @Override
    public Match startMatch(Long matchId) {
       matchData = Match.builder().id(123)
        .bluePlayer(Joueur.builder().clubName("Club Karaté Bleu").name("Khalid").build())
        .redPlayer(Joueur.builder().clubName("Club Karaté Rouge").name("Fouad").build())
        .CompetitionName("Wosho Championship regional Rabat")
        .startTime(LocalDateTime.now())
        .endTime(LocalDateTime.now().plusMinutes(3))
        .status(StatusMatch.EN_COURS)
        .build();
        List<Score> scores = new ArrayList<>();
         for (int i = 0; i < 5; i++) {
            scores.add(Score.builder().ArbitreName("Arbitre"+(i+1))
                           .blueScore(0)
                           .redScore(0)
                           .id(i)
                           .match(Match.builder().id(123).build())
                           .build());
        }
            matchData.setScores(scores);
        return matchData;

    }
    @Override
    public Match endtMatch(Long matchId) {
        matchData.setEndTime(LocalDateTime.now());
        matchData.setStatus(StatusMatch.TERMINE);
        return matchData;
    }

}
