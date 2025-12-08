package ru.kot1a.examples.spring.rate.limiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kot1a.examples.spring.rate.limiter.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
