package com.example.saessak.repository;

import com.example.saessak.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    // 자신의 이력서 확인
    Resume findByUserUserId(Long userId);
}
