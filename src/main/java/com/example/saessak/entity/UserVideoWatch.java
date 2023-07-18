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
    @Column(name = "user_video_id")
    // 유저-일자리ID
    private int userVideoId;

    @Column(name = "user_id")
    // 유저ID
    private int userId;

    @Column(name = "video_id")
    // 일자리ID
    private int videoId;
}
