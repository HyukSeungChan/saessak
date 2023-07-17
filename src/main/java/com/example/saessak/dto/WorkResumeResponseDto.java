package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.Work;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResumeResponseDto {

    private int workResumeId;

    private int workId;

    private int resumeId;

    private String state;
    private String date;

    // 이력서 정보
    private String title;
    private String name;
    private String gender;
    private int workPeriod;
    private long workHour;
    private long workMinute;



    public WorkResumeResponseDto(WorkResume workResume) {
        this.workResumeId = workResume.getWorkResumeId();
        this.workId = workResume.getWork().getWorkId();
        this.resumeId = workResume.getResume().getResumeId();
        this.state = workResume.getState();
        this.date = workResume.getDate();

        Resume resume = workResume.getResume();

        this.title = resume.getTitle();
        this.name = resume.getUser().getName();
        this.gender = resume.getGender();

        LocalDate startDate = LocalDate.parse(resume.getWorkStartDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(resume.getWorkEndDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.workPeriod = (int) ChronoUnit.DAYS.between(startDate, endDate);
        LocalTime startTime = LocalTime.parse(resume.getWorkStartTime(), DateTimeFormatter.ofPattern("H:mm"));
        LocalTime endTime = LocalTime.parse(resume.getWorkEndTime(), DateTimeFormatter.ofPattern("H:mm"));
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        this.workHour = hours;
        this.workMinute = minutes;
    }

}
