package com.fundooapp.messaging;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfig {
    @Configuration @EnableJms
    @ConditionalOnProperty(name = "fundoo.messaging.jms.enabled", havingValue = "true")
    static class JmsConfiguration {
        @Bean ConnectionFactory jmsConnectionFactory(@Value("${JMS_BROKER_URL:tcp://localhost:61616}") String url) { return new ActiveMQConnectionFactory(url); }
        @Bean JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) { return new JmsTemplate(connectionFactory); }
    }

    @Configuration
    @ConditionalOnProperty(name = "fundoo.messaging.rabbit.enabled", havingValue = "true")
    static class RabbitConfiguration {
        @Bean TopicExchange notesExchange() { return new TopicExchange("notes-exchange"); }
        @Bean Queue collaboratorQueue() { return new Queue("collaborator-notify-queue"); }
        @Bean Queue activityLogQueue() { return new Queue("activity-log-queue"); }
        @Bean Binding collaboratorBinding(Queue collaboratorQueue, TopicExchange notesExchange) { return BindingBuilder.bind(collaboratorQueue).to(notesExchange).with("note.shared"); }
        @Bean Binding activityBinding(Queue activityLogQueue, TopicExchange notesExchange) { return BindingBuilder.bind(activityLogQueue).to(notesExchange).with("note.shared"); }
    }
}
