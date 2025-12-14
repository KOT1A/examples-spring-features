package ru.kot1a.examples.spring.kafka.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class SpringKafkaStreamApp {
    public static void main(String[] args){
        SpringApplication.run(SpringKafkaStreamApp.class, args);
    }
}
