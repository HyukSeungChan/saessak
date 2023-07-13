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
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    // 게시글ID
    private int boardId;

    @Column(name = "title")
    // 제목
    private String title;

    @Column(name = "content")
    // 내용
    private String content;

    @Column(name = "image")
    // 사진
    private String image;

    @Column(name = "upload_time")
    // 업로드 시간
    private String uploadTime;

    @Column(name = "area")
    // 지역
    private String area;

    @Column(name = "likes")
    // 좋아요 수
    private int likes;

    @Column(name = "replies")
    // 댓글 수
    private int replies;

    @Column(name = "agriculture")
    // 카테고리(농업구분)
    private String agriculture;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @OneToMany(mappedBy = "board")
    // mapping
    private List<UserBoard> userBoards = new ArrayList<>();


}
