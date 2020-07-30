package com.github.mickroll.demonstrator.quarkus.observermock;

public class ExampleEvent {
    
    private final String description;

    public ExampleEvent(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExampleEvent [description=" + description + "]";
    }
}
