package ru.kot1a.examples.spring.rate.limiter.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Конфигурация кафки в application.yaml
 */
@Configuration
public class KafkaConfig {

    /**
     * Создаем топик
     * @return топик
     */
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("my-topic-one")
                .partitions(3)
                .build();
    }
}
