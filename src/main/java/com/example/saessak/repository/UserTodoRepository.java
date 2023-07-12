package com.example.saessak.repository;

import com.example.saessak.entity.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTodoRepository extends JpaRepository<UserTodo, Integer> {

    // 할 일 조회(유저)
    List<UserTodo> findAllByUserUserIdAndTodoDate(Long userId, String date);

}
