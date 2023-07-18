package com.example.saessak.dto;

import com.example.saessak.entity.Board;
import com.example.saessak.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    private int boardId;
    private String title;

    private String content;

    private String image;

    private String uploadTime;

    private String area;

    private int likes;

    private int replies;

    private String agriculture;

    private String crops;

    private Long userId;

    // 유저 정보
    private String name;
    private String profileImage;

    public BoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.uploadTime = board.getUploadTime();
        this.area = board.getArea();
        this.likes = board.getLikes();
        this.replies = board.getReplies();
        this.agriculture = board.getAgriculture();
        this.crops = board.getCrops();
        this.userId = board.getUser().getUserId();

        // 유저 정보
        this.name = board.getUser().getName();
        this.profileImage = board.getUser().getProfileImage();
    }

}
