package com.fundooapp.dto;

public record NoteRequest(Integer noteId, String title, String description, String color,
                          String typeOfNote, String imageUrl, String linkUrl) {}
