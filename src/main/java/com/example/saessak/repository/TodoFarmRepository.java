package com.example.saessak.repository;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.TodoFarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoFarmRepository extends JpaRepository<TodoFarm, Integer> {
}
