package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

    @Autowired
    private playerHolderRepo playerRepo;

    @Autowired
    private userInformationRepo userRepo;

    @Autowired
    private HelloPOJORepository repository;


    /*
    Homepage will contain all the navigation buttons.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        return "homepage";
    }

    /*
    Error Page when something goes wrong
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage(Map<String, Object> model){
        return "error";
    }

    /*
    This page just loads up the web page that contains the form to insert the information into.
     */
    @RequestMapping(value = "/createRecord", method = RequestMethod.GET)
    public String createRecord(Map<String, Object> model) {

        return "createRecord";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUser(Map<String, Object> model){
        return "createUser";
    }

    @RequestMapping(value = "/editRecord", method = RequestMethod.GET)
    public String editRecord(Map<String, Object> model, @RequestParam("firstName") String fName) {
        playerHolder storedPlayer = playerRepo.findByName(fName);
        model.put("editInfo", new playerHolder(storedPlayer.getName(), storedPlayer.getLastName(), storedPlayer.getWins(), storedPlayer.getLoses(), storedPlayer.getDraws(), storedPlayer.getTelNum()));
        return "editRecord";
    }


    /*
    This method loads the player record and stores the information.
     */
    @RequestMapping(value = "/loadRecord", method = RequestMethod.GET)
    public String loadRecord(Map<String, Object> model, @RequestParam("firstName") String fName) {
        playerHolder storedPlayer = playerRepo.findByName(fName);
        model.put("infoStored", new playerHolder(storedPlayer.getName(), storedPlayer.getLastName(), storedPlayer.getWins(), storedPlayer.getLoses(), storedPlayer.getDraws(), storedPlayer.getTelNum()));
        return "loadRecord";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveInfo(@RequestParam("firstName") String fName, @RequestParam("middleName") String mName, @RequestParam("lastName") String lName, @RequestParam("age") int age, @RequestParam("gender") String gender){
        userInformation user = new userInformation(fName, mName, lName, age, gender);
        userRepo.save(user);
        return "homepage";
    }

    /*
    Method before collects the information from the web form and then stores it within the MySQL database to be accessed later and then will direct you back to
    the homepage to access other areas of the web page such as going back to the start menu. acceptable.
     */
    @RequestMapping(value = "/saveRecord", method = RequestMethod.GET)
    public String playerInfo(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("wins") int wins, @RequestParam("loses") int loses, @RequestParam("draws") int draws,@RequestParam("contactNum") String telNum ){
        playerHolder player = new playerHolder(fName, lName, wins, loses, draws, telNum);
        playerRepo.save(player);
        return "homepage";
    }

}
