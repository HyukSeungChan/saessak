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
public class UserBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_board_id")
    // 유저-글ID
    private int userBoardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    // 글ID
    private Board board;
}
