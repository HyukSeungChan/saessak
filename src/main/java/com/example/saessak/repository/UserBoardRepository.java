package com.example.saessak.repository;

import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBoardRepository extends JpaRepository<UserBoard, Integer> {

    // 유저-글 즐겨찾기 리스트 조회
    List<UserBoard> findAllByUserUserId(Long userId);
}
