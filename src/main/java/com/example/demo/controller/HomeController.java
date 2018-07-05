package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import com.example.demo.domain.HelloPOJORepository;
import com.example.demo.domain.playerHolder;
import com.example.demo.domain.playerHolderRepo;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

    @Autowired
    private playerHolderRepo playerRepo;

    @Autowired
    private HelloPOJORepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        return "homepage";
    }

    /*
    This page just loads up the web page that contains the form to insert the information into.
     */
    @RequestMapping(value = "/createRecord", method = RequestMethod.GET)
    public String loadRecord(Map<String, Object> model) {

        return "createRecord";
    }

    /*
    Method before collects the information from the web form and then stores it within the MySQL database to be accessed later and then will direct you back to
    the homepage to access other areas of the web page such as going back to the start menu. acceptable
     */

    @RequestMapping(value = "/saveRecord", method = RequestMethod.GET)
    public String playerInfo(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("wins") int wins, @RequestParam("loses") int loses, @RequestParam("draws") int draws,@RequestParam("contactNum") String telNum ){
        playerHolder player = new playerHolder(fName, lName, wins, loses, draws, telNum);
        playerRepo.save(player);
        return "homepage";
    }

}
