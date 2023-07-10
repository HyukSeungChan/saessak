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
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    // 답글ID
    private int replyId;

    @Column(name = "content")
    // 내용
    private int content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    // 글ID
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

}
