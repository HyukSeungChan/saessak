package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    // 일자리ID
    private int workId;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장ID
    private Farm farm;

    @Column(name = "title")
    // 공고 제목
    private String title;

    @Column(name = "content")
    // 공고 내용
    private String content;

    @Column(name = "recruitment_start")
    // 모집 시작
    private String recruitmentStart;

    @Column(name = "recruitment_end")
    // 모집 마감
    private String recruitmentEnd;

    @Column(name = "recruitment_person")
    // 모집 인원
    private String recruitmentPerson;

    @Column(name = "qualification")
    // 지원자격
    private String qualification;

    @Column(name = "preferential_treatment")
    // 우대사항
    private String preferentialTreatment;

    @Column(name = "hour_wage")
    // 시급
    private int hourWage;

    @Column(name = "day_wage")
    // 일급
    private int dayWage;

    @Column(name = "work_start_day")
    // 근무 시작일
    private String workStartDay;

    @Column(name = "work_end_day")
    // 근무 마감일
    private String workEndDay;

    @Column(name = "work_start_time")
    // 근무 시작 시간
    private String workStartTime;

    @Column(name = "work_end_time")
    // 근무 마감 시간
    private String workEndTime;

    @Column(name = "state")
    // 모집 상태
    private String state;

    @Column(name = "career")
    // 경력
    private String career;

    @Column(name = "etc")
    // 기타
    private String etc;

    @OneToMany(mappedBy = "work")
    // mapping
    private List<WorkResume> workResumes = new ArrayList<>();

    @OneToMany(mappedBy = "work")
    // mapping
    private List<UserWork> userWorks = new ArrayList<>();


}
