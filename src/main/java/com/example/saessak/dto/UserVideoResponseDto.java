package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.UserVideo;
import com.example.saessak.entity.UserWork;
import com.example.saessak.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVideoResponseDto {

    private int userVideoId;

    private Long userId;
    private int videoId;

    // 동영상 정보
    private String title;

    private String link;

    public UserVideoResponseDto(UserVideo userVideo) {
        this.userVideoId = userVideo.getUserVideoId();
        this.userId = userVideo.getUser().getUserId();
        this.videoId = userVideo.getVideo().getVideoId();

        this.title = userVideo.getVideo().getTitle();
        this.link = userVideo.getVideo().getLink();

    }

}
