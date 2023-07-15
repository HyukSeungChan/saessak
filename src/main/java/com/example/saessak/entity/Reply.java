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
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    // 답글ID
    private int replyId;

    @Column(name = "content")
    // 내용
    private String content;


    @Column(name = "upload_time")
    // 업로드 시간
    private String uploadTime;

    @Column(name = "area")
    // 지역
    private String area;

    @ManyToOne
    @JoinColumn(name = "board_id")
    // 글ID
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @OneToMany(mappedBy = "reply")
    // mapping
    List<UserReply> userReplies = new ArrayList<>();

}
