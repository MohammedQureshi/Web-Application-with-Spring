package com.example.demo.controller;

import com.example.demo.domain.Game;
import com.example.demo.domain.Player;
import com.example.demo.domain.PlayerRepository;
import com.example.demo.service.ScrabbleDataService;
import com.example.demo.service.TestService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@Log
public class HomeController {

    @Autowired
    private TestService service;

    @Autowired
    private ScrabbleDataService scrabbleDataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        return "homepage";
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initData() {
        Player jamesBuilder = Player.builder()
                .playerName("JamesMillner")
                .build();

        jamesBuilder = scrabbleDataService.save(jamesBuilder);

        Player mohammed = Player.builder()
                .playerName("MohammedQureshi")
                .build();

        mohammed = scrabbleDataService.save(mohammed);

        Player ben = Player.builder().playerName("Ben").build();

        ben = scrabbleDataService.save(ben);

        Game firstGame = Game.builder()
                .playerOne(jamesBuilder)
                .playerTwo(mohammed)
                .playerOneScore(50)
                .playerTwoScore(80)
                .winner(mohammed)
                .build();

        scrabbleDataService.save(firstGame);

        Game secondGame = Game.builder()
                .playerOne(jamesBuilder)
                .playerTwo(mohammed)
                .playerOneScore(120)
                .playerTwoScore(25)
                .winner(jamesBuilder)
                .build();

        scrabbleDataService.save(secondGame);

        Game third = Game.builder()
                .playerOne(jamesBuilder)
                .playerTwo(ben)
                .playerOneScore(55)
                .playerTwoScore(56)
                .winner(ben)
                .build();


        scrabbleDataService.save(third);

        log.info("Built game data!!!");
        return "redirect:/";
    }

}
