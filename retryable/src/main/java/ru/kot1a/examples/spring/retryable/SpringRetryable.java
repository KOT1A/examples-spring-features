package ru.kot1a.examples.spring.retryable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringRetryable {

    public static void main(String[] args){
        SpringApplication.run(SpringRetryable.class, args);
    }
}
