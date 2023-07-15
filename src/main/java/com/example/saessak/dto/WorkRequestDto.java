package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.User;
import com.example.saessak.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkRequestDto {
    private int farmId;
    private String title;
    private String content;
    private String recruitmentStart;
    private String recruitmentEnd;
    private int recruitmentPerson;
    private String qualification;
    private String preferentialTreatment;
    private int hourWage;
    private int dayWage;

    private String workStartDay;

    private String workEndDay;

    private String workStartTime;

    private String workEndTime;

    private String state;

    private float career;
    private String etc;

    public Work toEntity() {

        Farm farm = Farm.builder().farmId(farmId).build();

        return Work.builder()
                .farm(farm)
                .title(title)
                .content(content)
                .recruitmentStart(recruitmentStart)
                .recruitmentEnd(recruitmentEnd)
                .recruitmentPerson(recruitmentPerson)
                .qualification(qualification)
                .preferentialTreatment(preferentialTreatment)
                .hourWage(hourWage)
                .dayWage(farm.getPay())
                .workStartDay(workStartDay)
                .workEndDay(workEndDay)
                .workStartTime(workStartTime)
                .workEndTime(workEndTime)
                .career(career)
                .state(state)
                .etc(etc)
                .build();
    }

}
