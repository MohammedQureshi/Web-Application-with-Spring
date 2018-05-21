package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        return "homepage";
    }

}
