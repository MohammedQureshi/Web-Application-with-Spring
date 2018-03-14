package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {

        System.out.println("helloooo");

        return "homepage";
    }

    @ResponseBody
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "The about me page.";
    }

}
