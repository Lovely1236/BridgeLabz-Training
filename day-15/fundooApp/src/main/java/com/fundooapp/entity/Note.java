package com.fundooapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean isPined;
    private boolean isArchived;
    private boolean isDeleted;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "note_note_labels",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<NoteLabel> labels = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "note_reminders", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "reminder_at")
    private List<LocalDateTime> reminders = new ArrayList<>();

    public Note() {}
    public Integer getNoteId() { return noteId; }
    public void setNoteId(Integer noteId) { this.noteId = noteId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isPined() { return isPined; }
    public void setPined(boolean pined) { isPined = pined; }
    public boolean isArchived() { return isArchived; }
    public void setArchived(boolean archived) { isArchived = archived; }
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getTypeOfNote() { return typeOfNote; }
    public void setTypeOfNote(String typeOfNote) { this.typeOfNote = typeOfNote; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getLinkUrl() { return linkUrl; }
    public void setLinkUrl(String linkUrl) { this.linkUrl = linkUrl; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public Set<NoteLabel> getLabels() { return labels; }
    public void setLabels(Set<NoteLabel> labels) { this.labels = labels; }
    public List<LocalDateTime> getReminders() { return reminders; }
    public void setReminders(List<LocalDateTime> reminders) { this.reminders = reminders; }
}
