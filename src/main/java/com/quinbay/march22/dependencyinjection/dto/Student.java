package com.quinbay.march22.dependencyinjection.dto;
import io.swagger.models.auth.In;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Student implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(){

    }

}
