package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import com.example.demo.domain.playerData;
import com.example.demo.domain.playerDataRespository;
import com.example.demo.domain.HelloPOJORepository;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

    @Autowired
    private HelloPOJORepository repository;

    @Autowired
    private playerDataRespository playerRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

//        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));
//
//        HelloPOJO pojo = (HelloPOJO) model.get("pojo");
//
//        System.out.println(pojo.getName() + " - " + pojo.getText());
//
//        service.runTestService();
//
//        System.out.println("SAVING USER!!!");
//
//        HelloPOJO user = new HelloPOJO("Yo1", "Helloooooooooo");
//        repository.save(user);
//
//        /* Searches though database to locate User */
//        HelloPOJO storedUser = repository.findByName("Yo");
//        System.out.println(storedUser.getText());


        return "homepage";
    }

    /**
     * Typical API response method.
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public List<HelloPOJO> getHelloPojos() {

        Map<String, HelloPOJO> model = new HashMap<>();

        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));
        model.put("pojo2", new HelloPOJO("James2", "Hello Again!asdasdasdasd!"));
        model.put("pojo3", new HelloPOJO("James", "Hello Again I'm number 3!!"));

        return new ArrayList<>(model.values());
    }

}
