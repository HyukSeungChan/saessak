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
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    // 이력서ID
    private int resumeId;

    @Column(name = "title")
    // 제목
    private String title;

    @Column(name = "area_first")
    // 희망 일자리1
    private String areaFirst;

    @Column(name = "area_second")
    // 희망 일자리2
    private String areaSecond;

    @Column(name = "area_third")
    // 희망 일자리3
    private String areaThird;

    @Column(name = "gender")
    // 성별
    private String gender;

    @Column(name = "birthday")
    // 생년월일
    private String birthday;

    @Column(name = "phone")
    // 전화번호
    private String phone;

    @Column(name = "email")
    // 이메일
    private String email;

    @Column(name = "address")
    // 주소
    private String address;

    @Column(name = "career")
    // 경력
    private String career;

    @Column(name = "account")
    // 계좌번호
    private String account;

    @Column(name = "bank")
    // 은행
    private String bank;

    @Column(name = "agriculture")
    // 농업 구분
    private String agriculture;

    @Column(name = "crops")
    // 작목
    private String crops;

    @Column(name = "work_start_day")
    // 근무시작기간
    private String workStartDay;

    @Column(name = "work_end_day")
    // 근무마감기간
    private String workEndDay;

    @Column(name = "work_start_time")
    // 근무시작시간
    private String workStartTime;

    @Column(name = "work_end_time")
    // 근무마감시간
    private String workEndTime;

    @Column(name = "car")
    // 차량보유
    private String car;

    @OneToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @OneToMany(mappedBy = "resume")
    // mapping
    private List<WorkResume> resumes = new ArrayList<>();
}
