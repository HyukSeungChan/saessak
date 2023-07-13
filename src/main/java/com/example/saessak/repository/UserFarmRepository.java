package com.example.saessak.repository;

import com.example.saessak.entity.UserFarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFarmRepository extends JpaRepository<UserFarm, Integer> {

    // 유저-농장에 속한 유저 조회
    List<UserFarm> findAllByFarmFarmId(int farmId);

    // 유저입장에서 자신이 속한 농장이 있는지 조회
    List<UserFarm> findAllByUserUserId(Long userId);

}
