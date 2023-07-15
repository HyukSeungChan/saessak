package com.example.saessak.dto;

import com.example.saessak.entity.*;
import com.example.saessak.repository.UserFarmRepository;
import com.example.saessak.repository.UserTodoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoFarmResponseDto {

    private int todoFarmId;
    private int farmId;
    private int todoId;

    // 할일 정보
    private String task;

    // 농장에 속한 사람
    private String name;

    public TodoFarmResponseDto(TodoFarm todoFarm, Todo todo, UserTodo userTodo, UserFarm userFarm) {

        this.todoFarmId = todoFarm.getTodoFarmId();
        this.farmId = todoFarm.getFarm().getFarmId();
        this.todoId = todoFarm.getTodo().getTodoId();

        this.task = todo.getTask();

    }

}
