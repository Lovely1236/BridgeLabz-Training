package com.fundooapp.controller;

import com.fundooapp.dto.*;
import com.fundooapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService notes;
    public NoteController(NoteService notes) { this.notes = notes; }

    @PostMapping("/addNotes") ResponseEntity<NoteResponse> add(@RequestBody NoteRequest request) { return ResponseEntity.status(HttpStatus.CREATED).body(notes.create(request)); }
    @GetMapping("/getNotesList") List<NoteResponse> list() { return notes.active(); }
    @GetMapping("/getNotesDetail/{noteId}") NoteResponse detail(@PathVariable Integer noteId) { return notes.detail(noteId); }
    @PostMapping("/updateNotes") NoteResponse update(@RequestBody NoteRequest request) { return notes.update(request); }
    @PostMapping("/pinUnpinNotes") NoteResponse pin(@Valid @RequestBody NoteStateRequest request) { return notes.pin(request); }
    @PostMapping("/archiveNotes") NoteResponse archive(@Valid @RequestBody NoteStateRequest request) { return notes.archive(request); }
    @PostMapping("/trashNotes") NoteResponse trash(@Valid @RequestBody NoteStateRequest request) { return notes.trash(request); }
    @PostMapping("/deleteForeverNotes") ResponseEntity<Void> deleteForever(@Valid @RequestBody NoteStateRequest request) { notes.deleteForever(request.noteId()); return ResponseEntity.noContent().build(); }
    @GetMapping("/getArchiveNotesList") List<NoteResponse> archiveList() { return notes.archived(); }
    @GetMapping("/getTrashNotesList") List<NoteResponse> trashList() { return notes.trashed(); }

    @GetMapping("/search") List<NoteResponse> search(@RequestParam(required = false) String titleText,
                                                     @RequestParam(required = false) String state,
                                                     @RequestParam(required = false) String label) { return notes.search(titleText, state, label); }

    @PostMapping("/{noteId}/addLabelToNotes/{labelId}/{action}")
    NoteResponse label(@PathVariable Integer noteId, @PathVariable Integer labelId, @PathVariable String action) {
        if (!action.equalsIgnoreCase("add") && !action.equalsIgnoreCase("remove")) throw new IllegalArgumentException("Action must be add or remove");
        return notes.addLabel(noteId, labelId, action.equalsIgnoreCase("add"));
    }

    @PostMapping("/addUpdateReminderNotes") NoteResponse addReminder(@Valid @RequestBody ReminderRequest request) { return notes.addReminder(request); }
    @PostMapping("/removeReminderNotes") NoteResponse removeReminder(@Valid @RequestBody ReminderRequest request) { return notes.removeReminder(request); }
    @GetMapping("/getReminderNotesList") List<NoteResponse> reminders() { return notes.reminders(); }
}
