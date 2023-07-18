package com.example.saessak.dto;

import com.example.saessak.entity.*;
import com.example.saessak.repository.FarmRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDto {

    private int replyId;

    private String content;
    private String uploadTime;

    private String area;
    private int boardId;
    private Long userId;

    public Reply toEntity(WorkerRepository workerRepository, FarmRepository farmRepository) {

        User user = User.builder().userId(userId).build();
        Board board = Board.builder().boardId(boardId).build();
        Worker worker = workerRepository.findByUserUserId(user.getUserId());
        Farm farm = farmRepository.findByUserUserId(user.getUserId());
        String areaValue = "";

        if (worker != null) {
            areaValue = worker.getArea();
        } else {
            String[] str = farm.getAddress().split(" ");
            areaValue = str[0] + " " + str[1];
        }

        // 지역을 보내야하나?? 고민해보기.
        return Reply.builder()
                .replyId(replyId)
                .content(content)
                .uploadTime(uploadTime)
                .area(areaValue)
                .board(board)
                .user(user)
                .build();
    }
}
