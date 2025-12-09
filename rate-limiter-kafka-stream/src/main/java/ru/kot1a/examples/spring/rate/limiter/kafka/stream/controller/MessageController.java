package ru.kot1a.examples.spring.rate.limiter.kafka.stream.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer.ProducerMyTopicOne;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final ProducerMyTopicOne producerMyTopicOne;

    @PostMapping
    public String send(@RequestBody String message) {
        for (int i=0; i<100; i++) {
            producerMyTopicOne.send(message);
        }
        return "В кафку отправлено сообщение: " + message;
    }
}
