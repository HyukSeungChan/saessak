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
    private String title;

    private String content;

    private String image;

    private String uploadTime;

    private String area;

    private int likes;

    private int replies;

    private String agriculture;

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
                .title(title)
                .content(content)
                .image(image)
                .uploadTime(uploadTime)
                .area(areaValue)
                .likes(likes)
                .replies(replies)
                .agriculture(agriculture)
                .user(user)
                .build();
    }

}
