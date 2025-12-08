package ru.kot1a.examples.spring.rate.limiter.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRateLimiterKafka {
    public static void main(String[] args){
        SpringApplication.run(SpringRateLimiterKafka.class, args);
    }
}
