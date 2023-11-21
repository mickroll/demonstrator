package com.example.reproducer.model;

import java.util.UUID;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Person {
    
    @EmbeddedId
    private PersonId id;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.id = new PersonId(UUID.randomUUID());
        this.name = name;
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
