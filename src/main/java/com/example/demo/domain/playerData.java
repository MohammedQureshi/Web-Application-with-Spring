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
    private String playerTelNumber;

}
