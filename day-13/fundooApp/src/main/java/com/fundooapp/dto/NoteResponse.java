package com.fundooapp.dto;

import com.fundooapp.entity.Note;
import java.time.LocalDateTime;
import java.util.*;

public record NoteResponse(Integer noteId, String title, String description, boolean pined,
                           boolean archived, boolean deleted, String color, String typeOfNote,
                           String imageUrl, String linkUrl, Set<String> labels,
                           List<LocalDateTime> reminders) {
    public static NoteResponse from(Note note) {
        return new NoteResponse(note.getNoteId(), note.getTitle(), note.getDescription(), note.isPined(),
                note.isArchived(), note.isDeleted(), note.getColor(), note.getTypeOfNote(), note.getImageUrl(),
                note.getLinkUrl(), note.getLabels().stream().map(l -> l.getLabel()).collect(java.util.stream.Collectors.toSet()),
                List.copyOf(note.getReminders()));
    }
}
