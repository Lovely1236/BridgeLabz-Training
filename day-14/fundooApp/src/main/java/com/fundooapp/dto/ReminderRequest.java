package com.fundooapp.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record ReminderRequest(@NotNull Integer noteId, @NotNull LocalDateTime reminder) {}
