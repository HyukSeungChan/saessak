package com.example.saessak.repository;

import com.example.saessak.entity.UserVideo;
import com.example.saessak.entity.UserVideoWatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVideoWatchRepository extends JpaRepository<UserVideoWatch, Integer> {
    // 시청한 영상 리스트
    List<UserVideoWatch> findAllByUserId(Long userId);
}
