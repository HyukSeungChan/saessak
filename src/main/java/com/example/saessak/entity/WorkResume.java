package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_resume_id")
    // 일자리-이력서ID
    private int workResumeId;

    @ManyToOne
    @JoinColumn(name = "work_id")
    // 일자리ID
    private Work work;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    // 이력서ID
    private Resume resume;

    @Column(name = "state")
    // 상태
    private String state;

    @Column(name = "date")
    // 지원날짜
    private String date;
}
