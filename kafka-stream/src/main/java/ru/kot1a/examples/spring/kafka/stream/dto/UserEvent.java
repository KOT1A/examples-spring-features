package ru.kot1a.examples.spring.kafka.stream.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserEvent {
    private UUID messageId;
    private String event; // ADD_FRIEND, SEND_MESSAGE, CHANGE_PASSWORD
    private String description;
    private Long userId;
}
