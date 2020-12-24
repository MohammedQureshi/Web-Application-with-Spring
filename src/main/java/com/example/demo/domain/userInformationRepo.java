package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userInformationRepo extends JpaRepository<userInformation, String> {

    userInformation findByfirstName(String stringy);

}
