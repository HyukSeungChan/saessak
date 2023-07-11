package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
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
public class FarmRequestDto {

    private int farmId;
    private String name;
    private String address;
    private String farmImage;
    private int pay;
    private String phone;
    private String introduction;
    private String agriculture;
    private String crops;
    private String cropsDetail;
    private String userId;

    public Farm toEntity() {

        User user = User.builder().userId(userId).build();

        return Farm.builder()
                .name(name)
                .address(address)
                .farmImage(farmImage)
                .pay(pay)
                .phone(phone)
                .introduction(introduction)
                .agriculture(agriculture)
                .crops(crops)
                .crops_detail(cropsDetail)
                .user(user)
                .build();
    }

}
