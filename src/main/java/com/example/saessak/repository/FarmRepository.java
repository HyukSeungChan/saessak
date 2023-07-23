package com.example.saessak.repository;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Integer> {
    // 유저로 농장주 찾기
    List<Farm> findByUserUserId(Long userId);
}
