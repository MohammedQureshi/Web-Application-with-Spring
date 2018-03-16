package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));

        HelloPOJO pojo = (HelloPOJO) model.get("pojo");

        System.out.println(pojo.getName() + " - " + pojo.getText());

        service.runTestService();

        return "homepage";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        service.runTestService();

        return "about-me";
    }

}
