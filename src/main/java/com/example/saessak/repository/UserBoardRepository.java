package com.example.saessak.repository;

import com.example.saessak.entity.UserBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBoardRepository extends JpaRepository<UserBoard, Integer> {
}
