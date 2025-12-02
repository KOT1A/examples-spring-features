package ru.kot1a.examples.spring.ratelimiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kot1a.examples.spring.ratelimiter.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
