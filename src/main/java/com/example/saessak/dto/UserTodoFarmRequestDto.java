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
public class UserTodoFarmRequestDto {

    private int userTodoFarmId;

    private Long userId;
    private int farmId;
    String todo;
    private String date;


}
