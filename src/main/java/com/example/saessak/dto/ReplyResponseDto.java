package com.example.saessak.dto;

import com.example.saessak.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDto {

    private int replyId;
    private String content;

    private String area;
    private String uploadTime;
    private int boardId;
    private Long userId;

    // 유저정보
    private String name;
    private String profileImage;


    public ReplyResponseDto(Reply reply) {
        this.replyId = reply.getReplyId();
        this.content = reply.getContent();
        this.area = reply.getArea();
        this.uploadTime = reply.getUploadTime();
        this.boardId = reply.getBoard().getBoardId();
        this.userId = reply.getUser().getUserId();

        this.name = reply.getUser().getName();
        this.profileImage = reply.getUser().getProfileImage();

    }
}
