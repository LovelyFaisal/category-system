package dev.faisals.springjpa.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDatabaseConflict(DataIntegrityViolationException ex) {
        // هنا نحول الضجيج التقني إلى إشارة واضحة
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "status", "error",
                        "message", "Invalid parent ID: The specified category does not exist."
                ));
    }
}