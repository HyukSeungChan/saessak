package com.example.saessak.repository;

import com.example.saessak.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // 리뷰 조회
    List<Review> findAllByFarmFarmId(int farmId);
}
