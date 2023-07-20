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
public class PolicySmart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_smart_id")
    // 지원정책ID
    private int policySmartId;

    @Column(name = "title")
    // 지원사업명
    private String title;

    @Column(name = "apply_content")
    // 지원내용
    private String applyContent;

    @Column(name = "type")
    // 사업 구분
    private String type;

    @Column(name = "outline")
    // 사업 개요
    private String outline;

    @Column(name = "main_content")
    // 주요 내용
    private String mainContent;

}
