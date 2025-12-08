package ru.kot1a.examples.spring.rate.limiter.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.rate.limiter.entity.User;
import ru.kot1a.examples.spring.rate.limiter.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/user/findAll")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RateLimiter(name = "basicLimiter")
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
