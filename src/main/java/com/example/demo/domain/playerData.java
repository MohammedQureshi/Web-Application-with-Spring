package com.example.demo.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class playerData {

    @Id
    private String playerName;
    private int playerWins;
    private int playerLoses;
    private int playerDraws;
    private int averageScore(){
        int averageScoreResult = 0;
        return averageScoreResult;
    }
    private int totalGamesPlayed(){
        int totalGames = 0;
        return totalGames;
    }
    private String playerTelNumber;

}
