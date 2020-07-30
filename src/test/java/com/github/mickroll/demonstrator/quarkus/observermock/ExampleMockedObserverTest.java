package com.github.mickroll.demonstrator.quarkus.observermock;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class ExampleMockedObserverTest implements WithAssertions {

    @InjectMock
    ExampleObserver exampleObserverMock;
    
    @Inject
    Event<ExampleEvent> exampleEvent;
    
    @Inject
    ExampleEventSender exampleEventSender;

    @Inject
    ExampleEventSenderCaller exampleEventSenderCaller;

    @AfterEach
    public void cleanup() {
        ExampleObserver.RECEIVED_EVENTS.clear();
    }
    
    @Test
    public void testFireEvent() {
        ExampleEvent event = new ExampleEvent("testFireDirectly");
        
        exampleEvent.fire(event);
        
        assertThat(ExampleObserver.RECEIVED_EVENTS).isEmpty();
    }
    
    @Test
    public void testFireEventFromSender() {
        ExampleEvent event = new ExampleEvent("testFireFromBean");
        
        exampleEventSender.send(event);
        
        assertThat(ExampleObserver.RECEIVED_EVENTS).isEmpty();
    }
    
    @Test
    public void testFireEventFromSenderCaller() {
        ExampleEvent event = new ExampleEvent("testFireEventFromSenderCaller");
        
        exampleEventSenderCaller.callSender(event);
        
        assertThat(ExampleObserver.RECEIVED_EVENTS).isEmpty();
    }
    
    @Test
    public void testDirectCallOnMockedBeanThatHasObserverMethod() {
        ExampleEvent event = new ExampleEvent("testDirectCallOnMockedBeanThatHasObserverMethod");
        
        exampleObserverMock.directAddEvent(event);
        
        assertThat(ExampleObserver.RECEIVED_EVENTS).isEmpty();
    }
}
