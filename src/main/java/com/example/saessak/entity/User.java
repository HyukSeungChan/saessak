package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "user_id")
    // 사용자 ID
    private String userId;

    @Column(name = "name")
    // 이름
    private String name;

    @Column(name = "profile_image")
    // 프로필 이미지
    private String profileImage;

    @Column(name = "phone")
    // 전화번호
    private String phone;

    @Column(name = "type")
    // 유저타입
    private String type;

    @OneToMany(mappedBy = "user")
    // mapping
    private List<UserBoard> userBoards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    // mapping
    private List<UserVideo> userVideos = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    // mapping
    private List<UserWork> userWorks = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    // mapping
    private List<UserSupport> userSupports = new ArrayList<>();

}
