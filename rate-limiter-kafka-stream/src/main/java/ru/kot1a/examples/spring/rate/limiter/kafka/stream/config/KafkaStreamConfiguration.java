package ru.kot1a.examples.spring.rate.limiter.kafka.stream.config;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer.ProducerMyTopicOne;
import ru.kot1a.examples.spring.rate.limiter.kafka.stream.producer.ProducerMyTopicTwo;

@Configuration
public class KafkaStreamConfiguration {

    @Bean
    public ProducerMyTopicOne producerMyTopicOne(StreamBridge streamBridge){
        return new ProducerMyTopicOne(streamBridge);
    }

    @Bean
    public ProducerMyTopicTwo producerMyTopicTwo(StreamBridge streamBridge){
        return new ProducerMyTopicTwo(streamBridge);
    }
}
