package ru.kot1a.examples.spring.rate.limiter.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Отправляем сообщение в топик my-topic-one
 */
@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class ProductController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/one")
    public ResponseEntity<String> createProduct(){
        String message = "Message = " + UUID.randomUUID();
        kafkaTemplate.send("my-topic-one", message);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
