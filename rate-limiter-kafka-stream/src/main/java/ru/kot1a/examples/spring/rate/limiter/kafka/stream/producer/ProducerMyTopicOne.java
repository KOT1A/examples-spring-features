package ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

@RequiredArgsConstructor
public class ProducerMyTopicOne {

    private static final String BINDING_NAME = "outputMyTopicProducer-stream-binding";

    private final StreamBridge streamBridge;

    public void send(String message) {
        streamBridge.send(BINDING_NAME, message);
    }
}
