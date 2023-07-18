package com.example.saessak.dto;

import com.example.saessak.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkRequestDto {

    private int userWorkId;
    private Long userId;
    private int workId;

    public UserWork toEntity() {
        Work work = Work.builder().workId(workId).build();
        User user = User.builder().userId(userId).build();

        return UserWork.builder()
                .userWorkId(userWorkId)
                .work(work)
                .user(user)
                .build();
    }

}
