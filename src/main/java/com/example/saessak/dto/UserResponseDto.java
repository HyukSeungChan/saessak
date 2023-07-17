package com.example.saessak.dto;

import com.example.saessak.entity.User;
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
public class UserResponseDto {

    private Long userId;
    private String name;
    private String profileImage;
    private String phone;
    private String type;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.phone = user.getPhone();
        this.type = user.getType();

    }

}
