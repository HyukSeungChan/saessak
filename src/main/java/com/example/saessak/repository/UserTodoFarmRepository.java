package com.example.saessak.repository;

import com.example.saessak.entity.UserTodoFarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTodoFarmRepository extends JpaRepository<UserTodoFarm, Integer> {

    // 할 일 조회(유저)
    List<UserTodoFarm> findAllByUserUserIdAndFarmFarmIdAndTodoDate(Long userId, int farmId, String date);

    // 할 일 조회(농장주)
    List<UserTodoFarm> findAllByFarmFarmIdAndTodoDate(int farmId, String date);
}
