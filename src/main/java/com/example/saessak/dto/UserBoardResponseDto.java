package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserWork;
import com.example.saessak.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBoardResponseDto {

    private int userBoardId;

    private Long userId;
    private int boardId;

    // 글 정보

    private String title;

    private String content;

    private String image;

    private String uploadTime;

    private String area;

    private int likes;

    private int replies;

    private String agriculture;

    // 유저 정보
    private String name;
    private String profileImage;

    public UserBoardResponseDto(UserBoard userBoard) {
        this.userBoardId = userBoard.getUserBoardId();
        this.userId = userBoard.getUser().getUserId();
        this.boardId = userBoard.getBoard().getBoardId();

        // 글 정보
        this.title = userBoard.getBoard().getTitle();
        this.content = userBoard.getBoard().getContent();
        this.image = userBoard.getBoard().getImage();
        this.uploadTime = userBoard.getBoard().getUploadTime();
        this.likes = userBoard.getBoard().getLikes();
        this.replies = userBoard.getBoard().getReplies();
        this.agriculture = userBoard.getBoard().getAgriculture();

        // 유저 정보
        this.name = userBoard.getUser().getName();
        this.profileImage = userBoard.getUser().getProfileImage();


    }

}
