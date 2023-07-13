package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserFarm;
import com.example.saessak.entity.UserTodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFarmResponseDto {

    private int userFarmId;

    private Long userId;
    private int farmId;

    // 유저 정보
    private String name;

    private String profileImage;

    // 농장 정보
    private String farmName;
    private String address;
    private String farmImage;
    private int pay;
    private String phone;
    private String introduction;
    private String agriculture;
    private String crops;
    private String cropsDetail;

    public UserFarmResponseDto(UserFarm userFarm, User user) {
        this.userFarmId = userFarm.getUserFarmId();
        this.userId = userFarm.getUser().getUserId();
        this.farmId = userFarm.getFarm().getFarmId();

        this.name = user.getName();
        this.profileImage = user.getProfileImage();
    }

    public UserFarmResponseDto(UserFarm userFarm, Farm farm) {
        this.userFarmId = userFarm.getUserFarmId();
        this.userId = userFarm.getUser().getUserId();
        this.farmId = userFarm.getFarm().getFarmId();

        this.farmName = farm.getName();

    }
}
