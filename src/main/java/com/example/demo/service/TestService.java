package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TestService {

    public void runTestService() {
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
    }
}
