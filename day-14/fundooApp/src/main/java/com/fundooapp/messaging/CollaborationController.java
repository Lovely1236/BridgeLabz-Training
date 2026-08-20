package com.fundooapp.messaging;

import com.fundooapp.dto.ShareNoteRequest;
import com.fundooapp.service.CurrentUserService;
import com.fundooapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/notes")
public class CollaborationController {
    private final RabbitEventPublisher publisher;
    private final CurrentUserService currentUser;
    private final NoteService notes;
    public CollaborationController(RabbitEventPublisher publisher, CurrentUserService currentUser, NoteService notes) { this.publisher = publisher; this.currentUser = currentUser; this.notes = notes; }
    @PostMapping("/share")
    ResponseEntity<?> share(@Valid @RequestBody ShareNoteRequest request) {
        notes.validateForSharing(request.noteId());
        publisher.publish(request, currentUser.get().getEmail());
        return ResponseEntity.accepted().body(Map.of("message", "Note sharing event published", "routingKey", "note.shared"));
    }
}
