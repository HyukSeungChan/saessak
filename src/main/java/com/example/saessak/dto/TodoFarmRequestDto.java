package com.example.saessak.dto;

import com.example.saessak.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoFarmRequestDto {
    private int farmId;
    private int todoId;

    public TodoFarm toEntity() {
        Farm farm = Farm.builder().farmId(farmId).build();
        Todo todo = Todo.builder().todoId(todoId).build();

        return TodoFarm.builder()
                .farm(farm)
                .todo(todo)
                .build();
    }

}
