package com.example.saessak.dto;

import com.example.saessak.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String userId;
    private String name;
    private String profileImage;
//    private String gender;
    private String phone;
//    private String birthyear;
//    private String birthday;
    private String type;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
//        this.gender = user.getGender();
        this.phone = user.getPhone();
//        this.birthyear = user.getBirthyear();
//        this.birthday = user.getBirthday();
        this.type = user.getType();

    }

}
