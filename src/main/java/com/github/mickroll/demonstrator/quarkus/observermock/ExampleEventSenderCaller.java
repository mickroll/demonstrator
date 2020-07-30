package com.github.mickroll.demonstrator.quarkus.observermock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExampleEventSenderCaller {

    private final ExampleEventSender exampleEventSender;

    @Inject
    public ExampleEventSenderCaller(final ExampleEventSender exampleEventSender) {
        this.exampleEventSender = exampleEventSender;
    }

    public void callSender(final ExampleEvent event) {
        exampleEventSender.send(event);
    }
}
