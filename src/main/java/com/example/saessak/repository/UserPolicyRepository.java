package com.example.saessak.repository;

import com.example.saessak.entity.UserPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPolicyRepository extends JpaRepository<UserPolicy, Integer> {

    // 지원정책 조회
    List<UserPolicy> findAllByUserUserId(Long userId);
}
