package com.github.mickroll.demonstrator.quarkus.observermock;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ExampleObserver {

    public static final List<ExampleEvent> RECEIVED_EVENTS = new ArrayList<>();
    
    public void onExampleEvent(@Observes ExampleEvent event) {
        RECEIVED_EVENTS.add(event);
    }
    
    public void directAddEvent(ExampleEvent event) {
        RECEIVED_EVENTS.add(event);
    }
}
