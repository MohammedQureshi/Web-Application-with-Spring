package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface playerHolderRepo extends JpaRepository<playerHolder, String> {

    playerHolder findByName(String stringy);
}
