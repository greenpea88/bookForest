package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    int countByEmail(String email);
}
