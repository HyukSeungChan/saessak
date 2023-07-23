package com.example.saessak.service;

import com.example.saessak.dto.TodoRequestDto;
import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.UserResponseDto;
import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import com.example.saessak.repository.TodoRepository;
import com.example.saessak.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    // 할 일 생성
    @Transactional
    public Todo save(TodoRequestDto todoRequestDto) {
        System.out.println("------ 할일 생성 ------");
        Todo todo = todoRequestDto.toEntity();
        return todoRepository.save(todo);
    }



}
