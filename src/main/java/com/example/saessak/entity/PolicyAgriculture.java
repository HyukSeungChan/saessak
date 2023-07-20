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
public class PolicyAgriculture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_agriculture_id")
    // 지원정책ID
    private int policyAgricultureId;

    @Column(name = "title")
    // 지원사업명
    private String title;

    @Column(name = "content")
    // 지원내용
    private String content;

    @Column(name = "qualification")
    // 지원내용
    private String qualification;

    @Column(name = "area")
    // 지역
    private String area;

    @Column(name = "inquiry")
    // 문의
    private String inquiry;

    @Column(name = "note")
    // 주체 기관
    private String note;

}
