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
public class playerHolder{
    @Id
    private String name;

    private String lastName;

    private int wins;

    private int loses;

    private int draws;

    private String telNum;
}
