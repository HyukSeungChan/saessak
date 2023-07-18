package com.example.saessak.repository;

import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVideoRepository extends JpaRepository<UserVideo, Integer> {

    // 유저-비디오 즐겨찾기 리스트 조회
    List<UserVideo> findAllByUserUserId(Long userId);

    // 유저-비디오 즐겨찾기 삭제
    void deleteByUserUserIdAndVideoVideoId(Long userId, int videoId);
}
