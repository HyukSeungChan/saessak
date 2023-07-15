package com.example.saessak.repository;

import com.example.saessak.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    // 유저로 노동자 찾기
    Worker findByUserUserId(Long userId);
}
