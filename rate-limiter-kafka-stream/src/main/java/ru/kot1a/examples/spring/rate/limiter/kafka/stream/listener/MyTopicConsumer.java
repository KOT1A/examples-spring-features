package ru.kot1a.examples.spring.rate.limiter.kafka.stream.listener;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer.ProducerMyTopicTwo;

import java.util.function.Consumer;

import static io.github.resilience4j.ratelimiter.RateLimiter.waitForPermission;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyTopicConsumer implements Consumer<String> {

    private final RateLimiterRegistry registry;
    private final ProducerMyTopicTwo producerMyTopicTwo;

    @Override
    public void accept(String message){
        waitForPermission(registry.rateLimiter("handler"));
        producerMyTopicTwo.send(message);
        log.info("Сообщение из Kafka: {}", message);
    }
}
