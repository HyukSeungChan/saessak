package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkListResponseDto {

    private int workId;

    private int farmId;

    private String title;

    private String recruitmentStart;

    private String recruitmentEnd;


    // 농장 정보

    private String name;
    private String address;
    private String farmImage;
    private String crops;
    private String cropsDetail;

//    public WorkListResponseDto(Work work){
//        this.workId = work.getWorkId();
//        this.farmId = work.getFarm().getFarmId();
//        this.title = work.getTitle();
//        this.content = work.getContent();
//        this.recruitmentStart = work.getRecruitmentStart();
//        this.recruitmentEnd = work.getRecruitmentEnd();
//        this.recruitmentPerson = work.getRecruitmentPerson();
//        this.qualification = work.getQualification();
//        this.preferentialTreatment = work.getPreferentialTreatment();
//        this.hourWage = work.getHourWage();
//        this.dayWage = work.getDayWage();
//        this.workStartDay = work.getWorkStartDay();
//        this.workEndDay = work.getWorkEndDay();
//        this.workStartTime = work.getWorkStartTime();
//        this.workEndTime = work.getWorkEndTime();
//        this.career = work.getCareer();
//        this.state = work.getState();
//        this.etc = work.getEtc();
//    }

    public WorkListResponseDto(Work work, Farm farm) {
        this.workId = work.getWorkId();
        this.farmId = work.getFarm().getFarmId();
        this.title = work.getTitle();
        this.recruitmentStart = work.getRecruitmentStart();
        this.recruitmentEnd = work.getRecruitmentEnd();

        this.name = farm.getName();
        this.address = farm.getAddress();
        this.farmImage = farm.getFarmImage();
        this.crops = farm.getCrops();
        this.cropsDetail = farm.getCrops_detail();

    }
}
