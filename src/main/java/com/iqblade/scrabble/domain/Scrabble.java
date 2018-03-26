package java.com.iqblade.scrabble.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class Scrabble {

    @Id
    private String playerName;
    private int playerWins;
    private int playerLoses;
    private int playerDraws;
    private String phoneNumber;

    //Method for Average Score
    //Method for Total Games



}
