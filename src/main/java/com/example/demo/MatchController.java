package com.example.demo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Match;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    // Injectez votre service ScoreService ici (assurez-vous de créer le service approprié)
    private final ScoreService scoreService;

    @Autowired
    public MatchController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    // Méthode GET pour récupérer un match par son ID
    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId) {
        // Utilisez le service pour récupérer les informations du match par son ID
        Match match = scoreService.getMatchById(matchId);

        // Vérifiez si le match a été trouvé
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Méthode POST pour mettre à jour le score d'un match
    @PostMapping("/updateScore")
    public ResponseEntity<String> updateScore(@RequestBody Score score) {
        // Utilisez le service pour mettre à jour le score du match
        boolean updated = scoreService.updateScore(score);

        // Vérifiez si la mise à jour a réussi
        if (updated) {
            return new ResponseEntity<>("Score mis à jour avec succès.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Échec de la mise à jour du score.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
