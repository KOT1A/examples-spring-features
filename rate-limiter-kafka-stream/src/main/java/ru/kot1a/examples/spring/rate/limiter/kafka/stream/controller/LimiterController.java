package ru.kot1a.examples.spring.rate.limiter.kafka.stream.controller;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/limiters")
@RequiredArgsConstructor
public class LimiterController {

    private final RateLimiterRegistry registry;

    @PostMapping("/{limiter}/{rps}")
    public ResponseEntity<Object> send(@PathVariable String limiter, @PathVariable int rps) {
        RateLimiterConfig newConfig = RateLimiterConfig.custom()
                .limitForPeriod(rps)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofSeconds(1))
                .build();

        registry.remove(limiter);
        registry.rateLimiter(limiter, newConfig);
        return ResponseEntity.ok().build();
    }
}
