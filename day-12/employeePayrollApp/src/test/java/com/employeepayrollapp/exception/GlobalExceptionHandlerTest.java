package com.employeepayrollapp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleResponseStatusException_shouldReturnCleanErrorResponse() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/api/employees/999");

        ResponseStatusException exception = new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Employee not found with id: 999"
        );

        ResponseEntity<ErrorResponse> response = globalExceptionHandler
                .handleResponseStatusException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(404, response.getBody().getStatus());
        assertEquals("Not Found", response.getBody().getError());
        assertEquals("Employee not found with id: 999", response.getBody().getMessage());
        assertEquals("/api/employees/999", response.getBody().getPath());
    }

    @Test
    void handleGenericException_shouldReturnInternalServerErrorResponse() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/api/employees");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler
                .handleGenericException(new RuntimeException("boom"), request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(500, response.getBody().getStatus());
        assertEquals("Internal Server Error", response.getBody().getError());
        assertEquals("Unexpected server error", response.getBody().getMessage());
        assertEquals("/api/employees", response.getBody().getPath());
    }
}
