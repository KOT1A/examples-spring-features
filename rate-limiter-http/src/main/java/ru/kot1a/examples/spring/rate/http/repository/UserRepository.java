package ru.kot1a.examples.spring.rate.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kot1a.examples.spring.rate.http.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
