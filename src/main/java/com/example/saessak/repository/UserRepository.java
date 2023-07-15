package com.example.saessak.repository;

import com.example.saessak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 유저 탈퇴
    void deleteByUserId(Long userId);



}
