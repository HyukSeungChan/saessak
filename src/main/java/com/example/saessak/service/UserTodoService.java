package com.example.saessak.service;

import com.example.saessak.dto.UserTodoRequestDto;
import com.example.saessak.dto.UserTodoResponseDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserTodo;
import com.example.saessak.entity.UserWork;
import com.example.saessak.repository.TodoRepository;
import com.example.saessak.repository.UserRepository;
import com.example.saessak.repository.UserTodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserTodoService {

    private final UserTodoRepository userTodoRepository;


    // 유저에게 할 일 할당 (농장주)
    @Transactional
    public UserTodo save(List<Long> userId, int todoId) {
        System.out.println("------ 유저에게 할 일 할당 (농장주) ------");
        UserTodoRequestDto userTodoRequestDto = new UserTodoRequestDto();
        for (Long user : userId) {
            UserTodo userTodo = userTodoRepository.save(userTodoRequestDto.toEntity(user, todoId));
        }
        return new UserTodo();
    }

//    @Transactional
//    public UserTodo save(UserTodoRequestDto userTodoRequestDto) {
//        System.out.println("------ 유저에게 할 일 할당 (농장주) ------");
//        return userTodoRepository.save(userTodoRequestDto.toEntity());
//    }

    // 할 일 조회(유저)
    @Transactional(readOnly = true)
    public List<UserTodoResponseDto> findAllByUserUserIdAndTodoDate(Long userId, String date) {
        System.out.println("------ 할 일 조회(유저) ------");
        List<UserTodo> entity = userTodoRepository.findAllByUserUserIdAndTodoDate(userId, date);
        return entity.stream().map(UserTodoResponseDto::new).collect(Collectors.toList());
    }

    // 할 일 조회 (농장주)
}
