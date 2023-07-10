package com.example.saessak.dto;

import com.example.saessak.entity.*;
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
public class WorkerRequestDto {

    private int workerId;
    private String certificate;
    private String area;
    private String agriculture;
    private String pay;
    private String crops;

    private String interestCrops;
    private String badge;
    private String userId;
    private List<WorkerTodo> workerTodos = new ArrayList<>();

    public Worker toEntity() {
        User user = User.builder().userId(userId).build();

        return Worker.builder()
                .certificate(certificate)
                .area(area)
                .agriculture(agriculture)
                .pay(pay)
                .crops(crops)
                .interestCrops(interestCrops)
                .badge(badge)
                .user(user)
                .workerTodos(workerTodos)
                .build();
    }

}
