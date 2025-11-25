package ru.kot1a.examples.spring.retryable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.retryable.component.ExampleRetry;

@RestController
@RequestMapping("/v1/retry")
@RequiredArgsConstructor
public class RetryController {

    private final ExampleRetry exampleRetry;

    @GetMapping
    public void exampleRetry(){
        exampleRetry.retryMethod();
    }
}
