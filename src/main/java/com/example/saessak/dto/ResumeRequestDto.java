package com.example.saessak.dto;
;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.User;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeRequestDto {

    private int resumeId;
    private String title;
    private String gender;
    private String birthday;
    private String phone;
    private String email;
    private String address;

    private float career;

    private String account;

    private String bank;
    private String agriculture;
    private String crops;
    private String workStartDay;
    private String workEndDay;
    private String workStartTime;
    private String workEndTime;
    private String car;
    private Long userId;

    public Resume toEntity() {

        User user = User.builder().userId(userId).build();

        return Resume.builder()
                .resumeId(resumeId)
                .title(title)
                .gender(gender)
                .birthday(birthday)
                .phone(phone)
                .email(email)
                .address(address)
                .agriculture(agriculture)
                .career(career)
                .account(account)
                .bank(bank)
                .crops(crops)
                .workStartDay(workStartDay)
                .workEndDay(workEndDay)
                .workStartTime(workStartTime)
                .workEndTime(workEndTime)
                .car(car)
                .user(user)
                .build();
    }
}
