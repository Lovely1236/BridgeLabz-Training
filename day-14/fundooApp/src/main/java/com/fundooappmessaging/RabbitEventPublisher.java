package com.fundooapp.messaging;

import com.fundooapp.dto.ShareNoteRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class RabbitEventPublisher {
    private final ObjectProvider<RabbitTemplate> rabbit;
    public RabbitEventPublisher(ObjectProvider<RabbitTemplate> rabbit) { this.rabbit = rabbit; }
    public void publish(ShareNoteRequest request, String ownerEmail) {
        RabbitTemplate template = rabbit.getIfAvailable();
        if (template != null) template.convertAndSend("notes-exchange", "note.shared",
                ownerEmail + " shared note " + request.noteId() + " with " + request.collaboratorEmail());
    }
}
