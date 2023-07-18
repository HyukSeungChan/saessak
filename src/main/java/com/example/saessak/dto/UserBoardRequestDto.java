package com.example.saessak.dto;

import com.example.saessak.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBoardRequestDto {

    private int userBoardId;
    private Long userId;
    private int boardId;

    public UserBoard toEntity() {
        Board board = Board.builder().boardId(boardId).build();
        User user = User.builder().userId(userId).build();

        return UserBoard.builder()
                .userBoardId(userBoardId)
                .board(board)
                .user(user)
                .build();
    }

}
