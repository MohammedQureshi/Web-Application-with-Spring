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

        return "homepage";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {

        return "about-me";
    }

}
