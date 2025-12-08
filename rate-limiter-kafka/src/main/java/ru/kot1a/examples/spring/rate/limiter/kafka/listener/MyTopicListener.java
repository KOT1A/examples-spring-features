package ru.kot1a.examples.spring.rate.limiter.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Вычитываем сообщение из топика my-topic-one
 */
@Slf4j
@Component
@KafkaListener(topics = "my-topic-one")
public class MyTopicListener {

    @KafkaHandler
    public void handler(String message){
        log.info("Вычитываем сообщение: {}", message);
    }
}
