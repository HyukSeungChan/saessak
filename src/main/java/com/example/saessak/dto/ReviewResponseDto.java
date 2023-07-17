package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Review;
import com.example.saessak.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {

    private String content;

    private String image;

    private String dateCreate;
    private Long userId;
    private int farmId;

    // 유저정보
    private String name;
    private String profileImage;

    public ReviewResponseDto(Review review) {
        this.content = review.getContent();
        this.image = review.getImage();
        this.dateCreate = review.getDateCreate();
        this.userId = review.getUser().getUserId();
        this.farmId = review.getFarm().getFarmId();

        this.name = review.getUser().getName();
        this.profileImage = review.getUser().getProfileImage();

    }

}
