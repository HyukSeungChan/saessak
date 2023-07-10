package com.example.saessak.repository;

import com.example.saessak.entity.WorkerTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerTodoRepository extends JpaRepository<WorkerTodo, Integer> {
}
