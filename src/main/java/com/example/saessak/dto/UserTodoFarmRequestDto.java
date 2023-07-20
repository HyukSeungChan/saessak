package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
//import com.example.saessak.entity.Todo;
import com.example.saessak.entity.Todo;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserTodoFarm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTodoFarmRequestDto {

    private int userTodoFarmId;

    private Long userId;
    private int farmId;
    String todo;
    private String date;


    private int farmId;

    private String date;

    private String task;

    public UserTodoFarm toEntity(Long userId, int todoId, int farmId) {
        User user = User.builder().userId(userId).build();
        Farm farm = Farm.builder().farmId(farmId).build();
        Todo todo = Todo.builder().todoId(todoId).build();

        return UserTodoFarm.builder()
                .userTodoFarmId(userTodoFarmId)
                .user(user)
                .farm(farm)
                .todo(todo)
                .build();
    }
>>>>>>> 768e6cc2cb7f73cf132432d4d1ef74e0144cf207
}

