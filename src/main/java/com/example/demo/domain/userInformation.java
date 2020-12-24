package com.example.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class userInformation {
    @Id
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String gender;
}