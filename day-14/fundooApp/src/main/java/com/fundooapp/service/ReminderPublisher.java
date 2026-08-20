package com.fundooapp.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ReminderPublisher {
    private final ObjectProvider<JmsTemplate> jms;
    public ReminderPublisher(ObjectProvider<JmsTemplate> jms) { this.jms = jms; }
    public void publish(Integer noteId, LocalDateTime reminder) {
        JmsTemplate template = jms.getIfAvailable();
        if (template != null) template.convertAndSend("reminder-queue", noteId + "|" + reminder);
    }
}
