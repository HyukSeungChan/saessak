package com.example.saessak.repository;

import com.example.saessak.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Integer> {
}
