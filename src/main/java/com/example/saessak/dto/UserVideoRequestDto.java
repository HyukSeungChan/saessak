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
public class UserVideoRequestDto {
    private Long userId;
    private int videoId;

    public UserVideo toEntity() {
        Video video = Video.builder().videoId(videoId).build();
        User user = User.builder().userId(userId).build();

        return UserVideo.builder()
                .video(video)
                .user(user)
                .build();
    }

}
