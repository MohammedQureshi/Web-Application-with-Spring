package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/about")
public class AboutController {

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public String about(Model model) {

        //Spring Version
        model.addAttribute("pojo", new HelloPOJO("James", "This is my text!!!! ABOUT ME PAGE!"));

        return "about-me";
    }

}
