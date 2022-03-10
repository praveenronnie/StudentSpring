package com.quinbay.march22.dependencyinjection.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class MongoEntity {

    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public MongoEntity() {
    }

    public MongoEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
