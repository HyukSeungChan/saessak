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
public class UserRequestDto {

    private Long userId;
    private String name;
    private String profileImage;
    private String phone;
    private String type;

    public User toEntity() {

        return User.builder()
                .userId(userId)
                .name(name)
                .profileImage(profileImage)
                .phone(phone)
                .type(type)
                .build();
    }

}
