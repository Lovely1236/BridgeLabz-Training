package com.mygreetingsapp.service;

import com.mygreetingsapp.model.Greeting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GreetingServiceTest {

    @Test
    void shouldSaveAndRetrieveGreeting() {
        GreetingService service = new GreetingService();

        Greeting saved = service.save(new Greeting(null, "Alice", "Hello"));

        assertNotNull(saved.getId());
        assertEquals("Alice", service.findById(saved.getId()).getName());
        assertEquals("Hello", service.findById(saved.getId()).getMessage());
    }

    @Test
    void shouldDeleteGreeting() {
        GreetingService service = new GreetingService();
        Greeting saved = service.save(new Greeting(null, "Bob", "Hi"));

        service.delete(saved.getId());

        assertNull(service.findById(saved.getId()));
    }
}
