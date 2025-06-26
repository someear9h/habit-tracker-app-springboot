package com.pm.habitservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // global advice for all controllers. If any controller throws an exception — this class will catch it
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage()));
        // error.getField() → gives: "email" or "name"
        // error.getDefaultMessage() → gives the message (from your DTO)

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HabitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleHabitNotFoundException(
            HabitNotFoundException ex) {
        log.warn("Habit Not found {}", ex.getMessage());

        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Habit not found");
        return ResponseEntity.badRequest().body(errors);
    }
}
