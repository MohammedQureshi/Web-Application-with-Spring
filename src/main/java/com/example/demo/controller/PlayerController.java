package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import com.example.demo.domain.playerData;
import com.example.demo.domain.playerDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PlayerController {

    @Autowired
    private playerDataRespository playerRepo;

    @RequestMapping(value="player", method= RequestMethod.GET)
    public String storeName(){

        return storeName();
    }

    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String viewProfile(Model model) {
        playerData player = playerRepo.findByPlayerName("A");
        model.addAttribute("player", player);
        return "viewProfile";
    }

    @RequestMapping(value = "/viewLeaderboard", method = RequestMethod.GET)
    public String viewLeaderboard(Model model) {

        return "viewLeaderboard";
    }

    @RequestMapping(value = "/createProfile", method = RequestMethod.GET)
    public String createProfile(Model model) {

        return "createProfile";
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editProfile(Model model) {
        playerData player = playerRepo.findByPlayerName("A");
        model.addAttribute("player", player);
        return "editProfile";
    }

}
