package com.example.saessak.dto;

import com.example.saessak.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkRecommendResponseDto {
    private String name;
    private String address;
    private String farmImage;
    private String agriculture;
    private String crops;

    private int workId;

    private String farmerName;

    public WorkRecommendResponseDto(Work work) {
        this.name = work.getFarm().getName();
        this.address = work.getFarm().getAddress();
        this.farmImage = work.getFarm().getFarmImage();
        this.agriculture = work.getFarm().getAgriculture();
        this.crops = work.getFarm().getCrops();
        this.workId = work.getWorkId();
        this.farmerName = work.getFarm().getUser().getName();

    }
}