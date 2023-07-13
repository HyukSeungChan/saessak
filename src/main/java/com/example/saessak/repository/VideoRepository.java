package com.example.saessak.repository;

import com.example.saessak.entity.VideoCrops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoCrops, Integer> {
}
