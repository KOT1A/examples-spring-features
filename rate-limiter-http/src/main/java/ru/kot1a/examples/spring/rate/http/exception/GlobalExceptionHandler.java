package ru.kot1a.examples.spring.rate.http.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<String> handleRateLimit(RequestNotPermitted ex) {
        return ResponseEntity.status(429).body("Too Many Requests");
    }
}
