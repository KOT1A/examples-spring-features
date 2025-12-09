package ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer;

import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

import static io.github.resilience4j.ratelimiter.RateLimiter.waitForPermission;

@RequiredArgsConstructor
public class ProducerMyTopicOne {

    private static final String BINDING_NAME = "outputMyTopicProducer-stream-binding";

    private final StreamBridge streamBridge;
    private final RateLimiterRegistry registry;

    public void send(String message) {
        waitForPermission(registry.rateLimiter("sender"));
        streamBridge.send(BINDING_NAME, message);
    }
}
