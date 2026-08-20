package com.fundooapp.service;

import com.fundooapp.dto.*;
import com.fundooapp.entity.*;
import com.fundooapp.exception.*;
import com.fundooapp.repository.*;
import com.fundooapp.specification.NoteSpecification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class NoteService {
    private final NoteRepository notes;
    private final NoteLabelRepository labels;
    private final CurrentUserService currentUser;
    private final ReminderPublisher reminderPublisher;

    public NoteService(NoteRepository notes, NoteLabelRepository labels, CurrentUserService currentUser,
                       ReminderPublisher reminderPublisher) {
        this.notes = notes; this.labels = labels; this.currentUser = currentUser; this.reminderPublisher = reminderPublisher;
    }

    @Transactional
    public NoteResponse create(NoteRequest request) {
        Note note = new Note(); note.setOwner(currentUser.get()); apply(note, request);
        return NoteResponse.from(notes.save(note));
    }

    @Transactional(readOnly = true)
    public List<NoteResponse> active() { return notes.findByOwnerAndIsDeletedFalseAndIsArchivedFalseOrderByNoteIdDesc(currentUser.get()).stream().map(NoteResponse::from).toList(); }
    @Transactional(readOnly = true)
    public List<NoteResponse> archived() { return notes.findByOwnerAndIsArchivedTrueAndIsDeletedFalseOrderByNoteIdDesc(currentUser.get()).stream().map(NoteResponse::from).toList(); }
    @Transactional(readOnly = true)
    public List<NoteResponse> trashed() { return notes.findByOwnerAndIsDeletedTrueOrderByNoteIdDesc(currentUser.get()).stream().map(NoteResponse::from).toList(); }

    @Transactional(readOnly = true)
    public NoteResponse detail(Integer id) { return NoteResponse.from(find(id)); }

    @Transactional(readOnly = true)
    public void validateForSharing(Integer id) { find(id); }

    @Transactional
    public NoteResponse update(NoteRequest request) {
        if (request.noteId() == null) throw new ResourceNotFoundException("noteId is required");
        Note note = find(request.noteId());
        if (note.isDeleted()) throw new InvalidNoteStateException("Cannot update a trashed note");
        apply(note, request); return NoteResponse.from(note);
    }

    @Transactional
    public NoteResponse pin(NoteStateRequest request) {
        Note note = find(request.noteId());
        if (note.isDeleted()) throw new InvalidNoteStateException("Cannot pin a trashed note");
        note.setPined(request.value() == null || request.value()); return NoteResponse.from(note);
    }

    @Transactional
    public NoteResponse archive(NoteStateRequest request) {
        Note note = find(request.noteId());
        if (note.isDeleted()) throw new InvalidNoteStateException("Cannot archive a trashed note");
        note.setArchived(request.value() == null || request.value()); return NoteResponse.from(note);
    }

    @Transactional
    public NoteResponse trash(NoteStateRequest request) {
        Note note = find(request.noteId()); note.setDeleted(true); note.setPined(false); return NoteResponse.from(note);
    }

    @Transactional
    public void deleteForever(Integer id) { notes.delete(find(id)); }

    @Transactional(readOnly = true)
    public List<NoteResponse> search(String title, String state, String label) {
        return notes.findAll(NoteSpecification.search(currentUser.get(), title, state, label)).stream().map(NoteResponse::from).toList();
    }

    @Transactional
    public NoteResponse addLabel(Integer noteId, Integer labelId, boolean add) {
        Note note = find(noteId);
        NoteLabel label = labels.findByIdAndOwner(labelId, currentUser.get())
                .filter(l -> !l.isDeleted()).orElseThrow(() -> new ResourceNotFoundException("Label not found"));
        if (add) note.getLabels().add(label); else note.getLabels().remove(label);
        return NoteResponse.from(note);
    }

    @Transactional
    public NoteResponse addReminder(ReminderRequest request) {
        Note note = find(request.noteId());
        if (note.isDeleted()) throw new InvalidNoteStateException("Cannot set a reminder on a trashed note");
        if (!note.getReminders().contains(request.reminder())) note.getReminders().add(request.reminder());
        NoteResponse response = NoteResponse.from(note);
        reminderPublisher.publish(note.getNoteId(), request.reminder());
        return response;
    }

    @Transactional
    public NoteResponse removeReminder(ReminderRequest request) {
        Note note = find(request.noteId()); note.getReminders().remove(request.reminder()); return NoteResponse.from(note);
    }

    @Transactional(readOnly = true)
    public List<NoteResponse> reminders() {
        return notes.findAll(NoteSpecification.search(currentUser.get(), null, null, null)).stream()
                .filter(n -> !n.getReminders().isEmpty()).map(NoteResponse::from).toList();
    }

    private Note find(Integer id) { return notes.findByNoteIdAndOwner(id, currentUser.get()).orElseThrow(() -> new ResourceNotFoundException("Note not found")); }
    private void apply(Note note, NoteRequest request) {
        if (request.title() != null) note.setTitle(request.title());
        if (request.description() != null) note.setDescription(request.description());
        if (request.color() != null) note.setColor(request.color());
        if (request.typeOfNote() != null) note.setTypeOfNote(request.typeOfNote());
        if (request.imageUrl() != null) note.setImageUrl(request.imageUrl());
        if (request.linkUrl() != null) note.setLinkUrl(request.linkUrl());
    }
}
