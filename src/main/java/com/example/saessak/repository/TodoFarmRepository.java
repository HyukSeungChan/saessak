package com.example.saessak.repository;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.TodoFarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoFarmRepository extends JpaRepository<TodoFarm, Integer> {

    // 할일-농장 조회
    List<TodoFarm> findAllByFarmFarmId(int farmId);
}
