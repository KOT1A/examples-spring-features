package ru.kot1a.examples.spring.hikari.cp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kot1a.examples.spring.hikari.cp.entity.User;
import ru.kot1a.examples.spring.hikari.cp.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("findAll");
        return userRepository.findAll();
    }
}
