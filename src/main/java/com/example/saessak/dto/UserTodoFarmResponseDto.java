package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
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
public class UserTodoFarmResponseDto {

    private int userTodoFarmId;
    private Long userId;
    private int todoId;
    private int farmId;

    // 일자리 정보
    private String task;

    // 노동자 정보
    private String name;
    private String profile_image;

    // 노동자
    public UserTodoFarmResponseDto(UserTodoFarm userTodoFarm) {
        this.userTodoFarmId = userTodoFarm.getUserTodoFarmId();
        this.userId = userTodoFarm.getUser().getUserId();
        this.todoId = userTodoFarm.getTodo().getTodoId();
        this.farmId = userTodoFarm.getFarm().getFarmId();

        this.task = userTodoFarm.getTodo().getTask();
    }

    // 농장주
    public UserTodoFarmResponseDto(UserTodoFarm userTodoFarm, User user) {
        this.userTodoFarmId = userTodoFarm.getUserTodoFarmId();
        this.userId = userTodoFarm.getUser().getUserId();
        this.todoId = userTodoFarm.getTodo().getTodoId();
        this.farmId = userTodoFarm.getFarm().getFarmId();

        this.task = userTodoFarm.getTodo().getTask();

        this.name = userTodoFarm.getUser().getName();
        this.profile_image = userTodoFarm.getUser().getProfileImage();

    }
}
