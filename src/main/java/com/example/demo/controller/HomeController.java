package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        //Java 8 Version

        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));
        model.put("pojo2", new HelloPOJO("James2", "Hello Again!asdasdasdasd!"));
        model.put("pojo3", new HelloPOJO("James", "Hello Again I'm number 3!!"));

        HelloPOJO p = (HelloPOJO) model.get("pojo");

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
