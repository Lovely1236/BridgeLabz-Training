package com.fundooapp.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "fundoo.messaging.jms.enabled", havingValue = "true")
class ReminderConsumer {
    @JmsListener(destination = "reminder-queue")
    public void processReminder(String message) { System.out.println("Reminder received: " + message); }
}

@Component
@ConditionalOnProperty(name = "fundoo.messaging.rabbit.enabled", havingValue = "true")
class CollaborationConsumers {
    @RabbitListener(queues = "collaborator-notify-queue")
    public void notifyCollaborator(String message) { System.out.println("Collaborator notification: " + message); }
    @RabbitListener(queues = "activity-log-queue")
    public void logActivity(String message) { System.out.println("Activity log: " + message); }
}
