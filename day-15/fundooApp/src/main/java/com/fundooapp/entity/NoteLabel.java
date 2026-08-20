package com.fundooapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "note_labels", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "label"}))
public class NoteLabel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String label;
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User owner;

    public NoteLabel() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
