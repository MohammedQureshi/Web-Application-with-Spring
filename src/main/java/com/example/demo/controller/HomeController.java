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

        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));

        HelloPOJO pojo = (HelloPOJO) model.get("pojo");

        System.out.println(pojo.getName() + " - " + pojo.getText());

        service.runTestService();

        System.out.println("SAVING USER!!!");

        HelloPOJO user = new HelloPOJO(UUID.randomUUID().toString(), "Helloooooooooo");
        repository.save(user);

        return "homepage";
    }


    @RequestMapping(value = "/player", method = RequestMethod.GET)
    @ResponseBody
    public String firstName(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("wins") int wins, @RequestParam("loses") int loses, @RequestParam("draws") int draws,@RequestParam("contactNum") String telNum ){
        playerHolder player = new playerHolder(fName, lName, wins, loses, draws, telNum);
        playerRepo.save(player);
        return "loadRecord";
    }

}
