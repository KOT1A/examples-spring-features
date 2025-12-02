package ru.kot1a.examples.spring.ratelimiter.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.ratelimiter.entity.User;
import ru.kot1a.examples.spring.ratelimiter.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/user/findAll")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
