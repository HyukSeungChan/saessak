package com.example.saessak.dto;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDto {

    private int todoId;
    private String date;
    private String task;

    public TodoResponseDto(Todo todo) {
        this.todoId = todo.getTodoId();
        this.date = todo.getDate();
        this.task = todo.getTask();
    }

}
