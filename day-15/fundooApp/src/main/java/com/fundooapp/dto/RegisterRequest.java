package com.fundooapp.dto;

import jakarta.validation.constraints.*;

public record RegisterRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email @NotBlank String email,
        @Size(min = 8, max = 100) String password) {}
