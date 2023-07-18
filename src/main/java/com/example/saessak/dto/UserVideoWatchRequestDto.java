package com.example.saessak.dto;

import com.example.saessak.entity.User;
import com.example.saessak.entity.UserVideo;
import com.example.saessak.entity.UserVideoWatch;
import com.example.saessak.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVideoWatchRequestDto {
    private Long userId;
    private int videoId;

    public UserVideoWatch toEntity() {
        return UserVideoWatch.builder()
                .userId(userId)
                .videoId(videoId)
                .build();
    }

}
