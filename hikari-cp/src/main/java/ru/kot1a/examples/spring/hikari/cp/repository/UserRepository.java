package ru.kot1a.examples.spring.hikari.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kot1a.examples.spring.hikari.cp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
