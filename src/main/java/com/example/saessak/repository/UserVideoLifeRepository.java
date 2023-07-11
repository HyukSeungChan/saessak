package com.example.saessak.repository;

import com.example.saessak.entity.UserVideoCrops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVideoLifeRepository extends JpaRepository<UserVideoCrops, Integer> {
}
