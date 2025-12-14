package ru.kot1a.examples.spring.rate.http.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kot1a.examples.spring.rate.http.entity.User;
import ru.kot1a.examples.spring.rate.http.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
