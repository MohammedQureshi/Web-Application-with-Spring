package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HelloPOJO {

    @Id
    private String name;

    private String text;

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

    public HelloPOJO() {

    }

    public HelloPOJO(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
