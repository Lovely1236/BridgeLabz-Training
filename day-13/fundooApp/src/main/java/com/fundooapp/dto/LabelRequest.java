package com.fundooapp.dto;

import jakarta.validation.constraints.NotBlank;

public record LabelRequest(@NotBlank String label) {}
