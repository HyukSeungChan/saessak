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
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    // 영상ID
    private int videoId;

    @Column(name = "title")
    // 영상제목
    private String title;

    @Column(name = "source")
    // 출처
    private String source;

    @Column(name = "link")
    // 영상링크
    private String link;

    @Column(name = "type")
    // 영상타입
    private String type;

    @Column(name = "crops")
    // 작물구분
    private String crops;

    @Column(name = "crops_name")
    // 작물명
    private String cropsName;

    @Column(name = "thumbnail")
    // 썸네일
    private String thimbnail;

    @OneToMany(mappedBy = "video")
    // mapping
    private List<UserVideo> userVideos = new ArrayList<>();
}
