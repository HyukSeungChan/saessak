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

    private String dateStart;

    private String dateEnd;
    private Long userId;
    private int farmId;

    // 유저 정보
    private String name;

    private String profileImage;

    // 농장 정보
    private String farmName;
    private String address;
    private String phone;
    private String introduction;

    public UserFarmResponseDto(UserFarm userFarm, User user, Farm farm) {
        this.userFarmId = userFarm.getUserFarmId();
        this.dateStart = userFarm.getDateStart();
        this.dateEnd = userFarm.getDateEnd();
        this.userId = userFarm.getUser().getUserId();
        this.farmId = userFarm.getFarm().getFarmId();

        this.name = user.getName();
        this.profileImage = user.getProfileImage();

        this.farmName = farm.getName();
        this.address = farm.getAddress();
        this.phone = farm.getPhone();
        this.introduction = farm.getIntroduction();

    }

}
