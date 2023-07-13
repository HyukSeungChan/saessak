package com.example.saessak.dto;

import java.util.ArrayList;
import java.util.List;

public class WorkerSignUpDto {

    private Long userId;
    private String name;
    private String profileImage;
    private String phone;
    private String type;


    public WorkerSignUpDto() {
        this.userId = null;
        this.name = "";
        this.profileImage = "";
        this.phone = "";
        this.type = "";
    }

    public WorkerSignUpDto(Long userId,
                String name,
                String profileImage,
                String phone,
                String type) {

        this.userId = userId;
        this.name = name;
        this.profileImage = profileImage;
        this.phone = phone;
        this.type = type;

    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
