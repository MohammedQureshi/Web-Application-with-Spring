package com.example.demo.domain;

import java.util.Date;

public class HelloPOJO {

    private String name;

    private String text;

    private Date created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloPOJO(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
