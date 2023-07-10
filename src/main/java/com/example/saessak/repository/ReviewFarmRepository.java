package com.example.saessak.repository;

import com.example.saessak.entity.Review;
import com.example.saessak.entity.ReviewFarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewFarmRepository extends JpaRepository<ReviewFarm, Integer> {
}
