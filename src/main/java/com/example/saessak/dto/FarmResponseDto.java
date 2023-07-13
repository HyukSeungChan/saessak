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
public class FarmResponseDto {

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

    private Long userId;

    public FarmResponseDto(Farm farm) {
        this.farmId = farm.getFarmId();
        this.name = farm.getName();
        this.address = farm.getAddress();
        this.farmImage = farm.getFarmImage();
        this.pay = farm.getPay();
        this.phone = farm.getPhone();
        this.introduction = farm.getIntroduction();
        this.agriculture = farm.getAgriculture();
        this.crops = farm.getCrops();
        this.cropsDetail = farm.getCrops_detail();
        this.userId = farm.getUser().getUserId();
    }

}
