package ru.mycomp.preproj231.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;

    private int age;
    private String workPosition;

    public User(String name, int age, String workPosition) {
        this.name = name;
        this.age = age;
        this.workPosition = workPosition;
    }



}
