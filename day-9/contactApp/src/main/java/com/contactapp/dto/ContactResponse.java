package com.contactapp.dto;

public record ContactResponse(
        Long id,
        String name,
        String email,
        String phone
) {
}