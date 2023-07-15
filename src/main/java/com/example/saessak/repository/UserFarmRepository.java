package com.example.saessak.repository;

import com.example.saessak.entity.UserFarm;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFarmRepository extends JpaRepository<UserFarm, Integer> {

    // 유저-농장에 속한 유저 조회
    List<UserFarm> findAllByFarmFarmId(int farmId);

    // 유저입장에서 자신이 속한 농장이 있는지 조회
    List<UserFarm> findAllByUserUserId(Long userId);

    // 농장 나가기 유저 찾기(노동자)
    UserFarm findByUserUserIdAndFarmFarmId(Long userId, int farmId);

    // 농장 나가기 중간에 (노동자)
    void deleteByUserUserIdAndFarmFarmId(Long userId, int farmId);

    // 농장 기간만료 유저 찾기(노동자)
    UserFarm findByUserUserIdAndDateEnd(Long userId, String dateEnd);

    // 농장 나가기 기간만료 (노동자)
    void deleteUserFarmByUserUserIdAndDateEnd(Long userId, String dateEnd);


}
