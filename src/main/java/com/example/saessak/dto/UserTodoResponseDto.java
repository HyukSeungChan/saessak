package com.example.saessak.dto;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserTodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTodoResponseDto {

    private int userTodoId;
    private Long userId;
    private int todoId;

    // 할일
    private String task;

    public UserTodoResponseDto (UserTodo userTodo) {
        this.userTodoId = userTodo.getUserTodoId();
        this.userId = userTodo.getUser().getUserId();
        this.todoId = userTodo.getTodo().getTodoId();
        this.task = userTodo.getTodo().getTask();
    }

}
