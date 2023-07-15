package com.example.saessak.dto;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserTodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTodoRequestDto {
    private Long userId;
    private int todoId;

    public UserTodo toEntity(Long userId, int todoId) {
        User user = User.builder().userId(userId).build();
        Todo todo = Todo.builder().todoId(todoId).build();

        return UserTodo.builder()
                .user(user)
                .todo(todo)
                .build();
    }

}
