package ru.kot1a.examples.spring.hikari.cp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.hikari.cp.entity.User;
import ru.kot1a.examples.spring.hikari.cp.service.UserService;

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
