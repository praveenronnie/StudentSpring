package com.quinbay.march22.dependencyinjection.Entity;

import com.quinbay.march22.dependencyinjection.dto.Student;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "Student Name cannot be empty")
    private String name;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public StudentEntity() {
    }

    public StudentEntity(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

