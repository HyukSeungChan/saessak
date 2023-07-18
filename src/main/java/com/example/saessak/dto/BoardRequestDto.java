package com.example.saessak.dto;

import com.example.saessak.entity.Board;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.User;
import com.example.saessak.entity.Worker;
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
public class BoardRequestDto {

    private int boardId;

    private String title;

    private String content;

    private String uploadTime;

    private String area;

    private String image;

    private int likes;

    private int replies;

    private String agriculture;

    private String crops;
    private Long userId;

    public Board toEntity(WorkerRepository workerRepository, FarmRepository farmRepository) {
        User user = User.builder().userId(userId).build();
        Worker worker = workerRepository.findByUserUserId(user.getUserId());
        Farm farm = farmRepository.findByUserUserId(user.getUserId());
        String areaValue = "";

        if (worker != null) {
            areaValue = worker.getArea();
        } else {
            String[] str = farm.getAddress().split(" ");
            areaValue = str[0] + " " + str[1];
        }

        return Board.builder()
                .boardId(boardId)
                .title(title)
                .content(content)
                .uploadTime(uploadTime)
                .area(areaValue)
                .image(image)
                .likes(likes)
                .replies(replies)
                .agriculture(agriculture)
                .crops(crops)
                .user(user)
                .build();
    }

}
