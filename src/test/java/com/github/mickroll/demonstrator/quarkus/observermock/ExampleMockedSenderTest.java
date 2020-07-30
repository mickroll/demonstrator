package com.github.mickroll.demonstrator.quarkus.observermock;

import javax.inject.Inject;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class ExampleMockedSenderTest implements WithAssertions {
    
    @InjectMock
    ExampleEventSender exampleEventSenderMock;

    @Inject
    ExampleEventSenderCaller exampleEventSenderCaller;

    @AfterEach
    public void cleanup() {
        ExampleObserver.RECEIVED_EVENTS.clear();
    }
    
    @Test
    public void testFireEventFromSenderCaller() {
        ExampleEvent event = new ExampleEvent("testExampleEventSenderCaller");
        
        exampleEventSenderCaller.callSender(event);
        
        assertThat(ExampleObserver.RECEIVED_EVENTS).isEmpty();
    }
}
