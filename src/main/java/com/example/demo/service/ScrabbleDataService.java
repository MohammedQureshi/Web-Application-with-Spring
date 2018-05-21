package com.example.demo.service;

import com.example.demo.domain.Game;
import com.example.demo.domain.GameRepository;
import com.example.demo.domain.Player;
import com.example.demo.domain.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrabbleDataService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }
}
