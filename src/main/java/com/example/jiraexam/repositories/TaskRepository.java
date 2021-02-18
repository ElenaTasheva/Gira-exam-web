package com.example.jiraexam.repositories;

import com.example.jiraexam.models.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
