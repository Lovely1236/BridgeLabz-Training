package com.mygreetingsapp.service;

import com.mygreetingsapp.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private final ConcurrentHashMap<Long, Greeting> greetings = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public List<Greeting> findAll() {
        return new ArrayList<>(greetings.values());
    }

    public Greeting save(Greeting greeting) {
        if (greeting.getId() == null) {
            long id = sequence.getAndIncrement();
            greeting.setId(id);
        }
        greetings.put(greeting.getId(), greeting);
        return greeting;
    }

    public Greeting findById(Long id) {
        return greetings.get(id);
    }

    public void delete(Long id) {
        greetings.remove(id);
    }
}
