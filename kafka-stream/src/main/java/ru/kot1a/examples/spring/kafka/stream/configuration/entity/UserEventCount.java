package ru.kot1a.examples.spring.kafka.stream.configuration.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEventCount {

    private Long userId;
    private Long count;

    public UserEventCount(Long userId, Long count) {
        this.userId = userId;
        this.count = count;
    }
}
