package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import com.example.demo.domain.HelloPOJORepository;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

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

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {

        HelloPOJO result = repository.findByName("23c87dce-b3f5-4666-8483-36c4eb284c9d");

        System.out.println(result.getName() + " = " + result.getText());

        result.setText("Yo!!!");

        repository.save(result);

        service.runTestService();

        return "about-me";
    }

}
