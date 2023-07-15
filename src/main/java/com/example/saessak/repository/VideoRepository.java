package com.example.saessak.repository;

import com.example.saessak.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {

    // 타입에 따른 영상 리스트 조회
    List<Video> findAllByType(String type);
}
