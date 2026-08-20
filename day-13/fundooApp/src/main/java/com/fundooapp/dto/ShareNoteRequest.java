package com.fundooapp.dto;

import jakarta.validation.constraints.*;

public record ShareNoteRequest(@NotNull Integer noteId, @Email @NotBlank String collaboratorEmail) {}
