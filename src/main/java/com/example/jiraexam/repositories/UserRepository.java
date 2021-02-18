package com.example.jiraexam.repositories;

import com.example.jiraexam.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmailAndPassword(String password, String email);
    User getByEmail(String email);
}
