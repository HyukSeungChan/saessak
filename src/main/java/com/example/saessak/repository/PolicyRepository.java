package com.example.saessak.repository;

import com.example.saessak.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    // 지원정책 조회
    List<Policy> findAllByType(String type);

    // 귀농귀촌 지원 필터링(지역) -> 해야하나..??
}
