package com.example.saessak.dto;

import com.example.saessak.entity.*;
import com.example.saessak.repository.FarmRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {

    private String content;

    private String image;

    private String dateCreate;
    private Long userId;
    private int farmId;

    public Review toEntity() {
        User user = User.builder().userId(userId).build();
        Farm farm = Farm.builder().farmId(farmId).build();

        return Review.builder()
                .content(content)
                .image(image)
                .dateCreate(dateCreate)
                .user(user)
                .farm(farm)
                .build();
    }

}
