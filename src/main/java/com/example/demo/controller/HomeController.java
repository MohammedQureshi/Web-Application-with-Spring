package com.example.demo.controller;

import com.example.demo.domain.HelloPOJO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Map<String, Object> model) {

        model.put("pojo", new HelloPOJO("James", "Hello Again!!"));

        System.out.println(model.get("key"));

        Set<String> set = new HashSet<>();
        set.add("James");
        set.add("Mohammed");
        set.add("Ant");
        set.add("James");

        for(String s : set) {
            System.out.println(s);
        }

        System.out.println("-");

        set.forEach(System.out::println);

        return "homepage";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about-me";
    }

}
