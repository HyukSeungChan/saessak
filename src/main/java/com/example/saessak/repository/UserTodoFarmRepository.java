package com.example.saessak.repository;

import com.example.saessak.entity.UserTodoFarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTodoFarmRepository extends JpaRepository<UserTodoFarm, Integer> {

    // 할 일 조회(유저)
    List<UserTodoFarm> findAllByUserUserIdAndFarmFarmIdAndTodoDate(Long userId, int farmId, String date);
    List<UserTodoFarm> findAllByUserUserIdAndFarmFarmId(Long userId, int farmId);

    // 할 일 조회(농장주)
    List<UserTodoFarm> findAllByFarmFarmIdAndTodoDate(int farmId, String date);


    // 할일 ID로 할일 찾기
    List<UserTodoFarm> findAllByTodoTodoId(int todoId);

    // 할 일 생성/수정 하기 전에 모두 삭제하고 시작
    void deleteAllByTodoTodoId(int todoId);

    // 할 일 삭제(농장주) 1개
    void deleteByTodoTodoId(int todoId);

}
