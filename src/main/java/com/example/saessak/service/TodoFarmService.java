package com.example.saessak.service;

import com.example.saessak.dto.TodoFarmRequestDto;
import com.example.saessak.dto.TodoFarmResponseDto;
import com.example.saessak.dto.TodoRequestDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.entity.*;
import com.example.saessak.repository.TodoFarmRepository;
import com.example.saessak.repository.UserFarmRepository;
import com.example.saessak.repository.UserTodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoFarmService {

    private final TodoFarmRepository todoFarmRepository;
//    private final UserTodoRepository userTodoRepository;
//
//    private final UserFarmRepository userFarmRepository;

    // 할일-농장 생성
    @Transactional
    public TodoFarm save(TodoFarmRequestDto todoFarmRequestDto) {
        System.out.println("------ 할일-농장 생성 ------");
        TodoFarm todoFarm = todoFarmRequestDto.toEntity();
        todoFarmRepository.save(todoFarm);
        return todoFarm;
    }

    // 할일-농장 조회
    @Transactional(readOnly = true)
    public List<TodoFarmResponseDto> findAllByFarmFarmId(int farmId) {
        System.out.println("------ 할일-농장 조회 ------");
        List<TodoFarm> entity = todoFarmRepository.findAllByFarmFarmId(farmId);
        return entity.stream().map(todoFarm -> new TodoFarmResponseDto(todoFarm, todoFarm.getTodo(), new UserTodo(), new UserFarm())).collect(Collectors.toList());
    }
}
