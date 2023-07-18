package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.User;
import com.example.saessak.entity.Worker;
import com.example.saessak.entity.UserFarm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFarmRequestDto {

    private int userFarmId;

    private String dateStart;

    private String dateEnd;
    private Long userId;
    private int farmId;

    public UserFarm toEntity() {
        User user = User.builder().userId(userId).build();
        Farm farm = Farm.builder().farmId(farmId).build();

        return UserFarm.builder()
                .userFarmId(userFarmId)
                .user(user)
                .farm(farm)
                .build();
    }
}
