package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
//import com.example.saessak.entity.Todo;
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
    private int farmId;
    private int todoId;
    private String task;
    private String date;

    // 노동자 정보
    private String name;
    private String profile_image;

    // 노동자
//    public UserTodoFarmResponseDto(UserTodoFarm userTodoFarm) {
//        this.userTodoFarmId = userTodoFarm.getUserTodoFarmId();
//        this.userId = userTodoFarm.getUser().getUserId();
//        this.farmId = userTodoFarm.getFarm().getFarmId();
//        this.date = userTodoFarm.getTodo().getDate();
//
//        this.task = userTodoFarm.getTodo().getTask();
//    }

    // 농장주
    public UserTodoFarmResponseDto(UserTodoFarm userTodoFarm) {
        this.userTodoFarmId = userTodoFarm.getUserTodoFarmId();
        this.userId = userTodoFarm.getUser().getUserId();
        this.todoId = userTodoFarm.getTodo().getTodoId();
        this.farmId = userTodoFarm.getFarm().getFarmId();
        this.date = userTodoFarm.getTodo().getDate();
        this.task = userTodoFarm.getTodo().getTask();

        this.name = userTodoFarm.getUser().getName();
        this.profile_image = userTodoFarm.getUser().getProfileImage();

    }
}
