package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVideoWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_video_watch_id")
    // 유저-비디오ID
    private int userVideoWatchId;

    @Column(name = "user_id")
    // 유저ID
    private Long userId;

    @Column(name = "video_id")
    // 비디오ID
    private int videoId;
}
