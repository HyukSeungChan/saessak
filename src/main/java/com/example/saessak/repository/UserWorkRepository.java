package com.example.saessak.repository;

import com.example.saessak.entity.UserWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWorkRepository extends JpaRepository<UserWork, Integer> {

    // 유저-일자리 즐겨찾기 조회
    List<UserWork> findAllByUserUserId(Long userId);

    // 유저-일자리 즐겨찾기 삭제
    void deleteByUserUserIdAndWorkWorkId(Long userId, int workId);
}
