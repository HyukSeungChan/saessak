package com.example.saessak.dto;
;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.User;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeRequestDto {

    private int resumeId;
    private String title;
    private String areaFirst;
    private String areaSecond;
    private String areaThird;
    private String gender;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    private String agriculture;
    private String crops;
    private String workStartDay;
    private String workEndDay;
    private String workStartTime;
    private String workEndTime;
    private String car;
    private Long userId;
    private List<WorkResume> resumes = new ArrayList<>();

    public Resume toEntity() {

        User user = User.builder().userId(userId).build();

        return Resume.builder()
                .title(title)
                .areaFirst(areaFirst)
                .areaSecond(areaSecond)
                .areaThird(areaThird)
                .gender(gender)
                .birthday(birthday)
                .phone(phone)
                .email(email)
                .address(address)
                .agriculture(agriculture)
                .crops(crops)
                .workStartDay(workStartDay)
                .workEndDay(workEndDay)
                .workStartTime(workStartTime)
                .workEndTime(workEndTime)
                .car(car)
                .user(user)
                .resumes(resumes)
                .build();
    }
}
