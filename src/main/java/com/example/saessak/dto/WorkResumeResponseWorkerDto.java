package com.example.saessak.dto;

import com.example.saessak.entity.Resume;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResumeResponseWorkerDto {

    private int workResumeId;

    private int workId;

    private int resumeId;

    private String state;
    private String date;

    // 일자리 정보
    private String address;
    private String title;
    private String recruitmentStart;
    private String recruitmentEnd;



    public WorkResumeResponseWorkerDto(WorkResume workResume) {
        this.workResumeId = workResume.getWorkResumeId();
        this.workId = workResume.getWork().getWorkId();
        this.resumeId = workResume.getResume().getResumeId();
        this.state = workResume.getState();
        this.date = workResume.getWork().getRecruitmentEnd();
        this.address = workResume.getWork().getFarm().getAddress();
        this.title = workResume.getWork().getTitle();
        this.recruitmentStart = workResume.getWork().getRecruitmentStart();
        this.recruitmentEnd = workResume.getWork().getRecruitmentEnd();
    }

}
