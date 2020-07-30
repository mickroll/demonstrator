package com.github.mickroll.demonstrator.quarkus.observermock;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class ExampleEventSender {

    private final Event<ExampleEvent> exampleEvent;

    @Inject
    public ExampleEventSender(final Event<ExampleEvent> exampleEvent) {
        this.exampleEvent = exampleEvent;
    }
    
    public void send(final ExampleEvent event) {
        exampleEvent.fire(event);
    }
}
