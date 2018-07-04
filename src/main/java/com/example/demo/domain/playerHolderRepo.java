package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloPOJORepository extends JpaRepository<HelloPOJO, String> {

    HelloPOJO findByName(String stringy);
}
