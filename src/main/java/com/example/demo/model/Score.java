package com.example.demo.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    int id;
    String ArbitreName ;
    int redScore;
    int blueScore;
    Match match;
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Score other = (Score) obj;
        return  id == other.id && ArbitreName.equals(other.ArbitreName) && match.getId() == other.match.getId();
    }

    @Override
    public int hashCode() {
        // Utilisez Objects.hash pour générer un code de hachage basé sur les attributs
        return Objects.hash(id, ArbitreName,match.getId());
    }
}
