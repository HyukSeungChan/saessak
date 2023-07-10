package com.example.saessak.repository;

import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVideoRepository extends JpaRepository<UserVideo, Integer> {
}
