package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Match;
import com.example.demo.model.Score;
import com.example.demo.service.CachedDataService;

@Controller
public class ScoreCardController {

	@Autowired
    private CachedDataService cachedDataService; 

	@MessageMapping("/scorecard")
	@SendTo("/topic/livescore")
	public ScoreCard getScoreCard(ScoreCard score) throws InterruptedException {
		//Thread.sleep(2000);
		return score;
	}

	@MessageMapping("/scoreMatch")
	@SendTo("/topic/livescoreMatch")
	public Match getScoreCard(Score score) throws InterruptedException {
		System.out.println(score.getRedScore());
		System.out.println(score.getBlueScore());
		 cachedDataService.updateLiveScoreData(score);
		 return cachedDataService.getLiveMatchData();
	}
}
