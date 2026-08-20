package com.fundooapp.exception;

import org.springframework.http.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> notFound(ResourceNotFoundException ex) { return body(HttpStatus.NOT_FOUND, ex.getMessage()); }
    @ExceptionHandler({ConflictException.class, InvalidNoteStateException.class})
    ResponseEntity<?> badRequest(RuntimeException ex) { return body(HttpStatus.BAD_REQUEST, ex.getMessage()); }
    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class})
    ResponseEntity<?> invalid(RuntimeException ex) { return body(HttpStatus.BAD_REQUEST, "Invalid request"); }
    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<?> unauthorized(Exception ex) { return body(HttpStatus.UNAUTHORIZED, "Invalid email or password"); }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> validation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return body(HttpStatus.BAD_REQUEST, message);
    }
    private ResponseEntity<?> body(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(java.util.Map.of("status", status.value(), "message", message));
    }
}
