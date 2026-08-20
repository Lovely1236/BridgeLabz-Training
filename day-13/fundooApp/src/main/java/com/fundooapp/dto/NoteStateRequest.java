package com.fundooapp.dto;

import jakarta.validation.constraints.NotNull;

public record NoteStateRequest(@NotNull Integer noteId, Boolean value) {}
