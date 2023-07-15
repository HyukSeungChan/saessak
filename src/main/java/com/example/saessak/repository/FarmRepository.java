package com.example.saessak.repository;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Integer> {
    // 유저로 농장주 찾기
    Farm findByUserUserId(Long userId);
}
