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
public class WorkResponseDto {

    private int workId;

    private int farmId;

    private String title;

    private String content;

    private String recruitmentStart;

    private String recruitmentEnd;

    private String recruitmentPerson;

    private String qualification;

    private String preferentialTreatment;

    private int hourWage;

    private int dayWage;

    private String workStartDay;

    private String workEndDay;

    private String workStartTime;

    private String workEndTime;

    private String state;
    private String etc;

    public WorkResponseDto(Work work){
        this.workId = work.getWorkId();
        this.farmId = work.getFarm().getFarmId();
        this.title = work.getTitle();
        this.content = work.getContent();
        this.recruitmentStart = work.getRecruitmentStart();
        this.recruitmentEnd = work.getRecruitmentEnd();
        this.recruitmentPerson = work.getRecruitmentPerson();
        this.qualification = work.getQualification();
        this.preferentialTreatment = work.getPreferentialTreatment();
        this.hourWage = work.getHourWage();
        this.dayWage = work.getDayWage();
        this.workStartDay = work.getWorkStartDay();
        this.workEndDay = work.getWorkEndDay();
        this.workStartTime = work.getWorkStartTime();
        this.workEndTime = work.getWorkEndTime();
        this.state = work.getState();
        this.etc = work.getEtc();
    }
}
