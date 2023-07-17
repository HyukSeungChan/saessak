package com.example.saessak.dto;

import com.example.saessak.entity.Resume;
import com.example.saessak.entity.User;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeResponseDto {

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

    private String name;

    public ResumeResponseDto(Resume resume) {
        this.resumeId = resume.getResumeId();
        this.title = resume.getTitle();
        this.name = resume.getUser().getName();
        this.gender = resume.getGender();
        this.birthday = resume.getBirthday();
        this.phone = resume.getPhone();
        this.email = resume.getEmail();
        this.address = resume.getAddress();
        this.career = resume.getCareer();
        this.account = resume.getAccount();
        this.bank = resume.getBank();
        this.agriculture = resume.getAgriculture();
        this.crops = resume.getCrops();
        this.workStartDay = resume.getWorkStartDay();
        this.workEndDay = resume.getWorkEndDay();
        this.workStartTime = resume.getWorkStartTime();
        this.workEndTime = resume.getWorkEndTime();
        this.car = resume.getCar();
        this.userId = resume.getUser().getUserId();
    }


}
