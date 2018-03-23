package com.example.demo.service;

import com.example.demo.domain.HelloPOJO;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JUnitTestService {

    public String addStringsTogether(List<String> stringList) {
        return stringList.stream().collect( Collectors.joining( "," ) );
    }

    /**
     *
     * This is a super cool method.
     *
     * @param pojos - This is a list of strings
     * @return return a formatted string
     */
    public List<String> getNames(List<HelloPOJO> pojos) {

        List<String> names = new ArrayList<>();

        for(HelloPOJO p : pojos) {
            names.add(p.getName());
        }

        //return names;

        return pojos.stream().map(HelloPOJO::getName).collect(Collectors.toList());
    }


}
