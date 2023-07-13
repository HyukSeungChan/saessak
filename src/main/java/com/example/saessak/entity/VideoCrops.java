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
public class VideoCrops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_crops_id")
    // 농작물 영상ID
    private int videoCropsId;

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

    @Column(name = "crops_name")
    // 작물명
    private String cropsName;

    @OneToMany(mappedBy = "videoCrops")
    // mapping
    private List<UserVideoCrops> userVideoCrops = new ArrayList<>();

}
