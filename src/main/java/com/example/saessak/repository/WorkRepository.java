package com.example.saessak.repository;

import com.example.saessak.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Integer> {
    // 전체 일자리 공고 보기
    List<Work> findAll();
}
