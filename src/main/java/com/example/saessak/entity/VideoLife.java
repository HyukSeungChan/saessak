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
public class VideoLife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_life_id")
    // 생활농업 영상ID
    private int videoLifeId;

    @Column(name = "title")
    // 영상제목
    private String title;

    @Column(name = "source")
    // 출처
    private String source;

    @Column(name = "source_name")
    // 출처명
    private String sourceName;

    @Column(name = "link")
    // 영상링크
    private String link;

    @OneToMany(mappedBy = "videoLife")
    // mapping
    private List<UserVideoLife> userVideoLifes = new ArrayList<>();

}
