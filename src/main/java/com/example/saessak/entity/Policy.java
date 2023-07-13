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
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    // 지원정책ID
    private int policyId;

    @Column(name = "name")
    // 지원사업명
    private String name;

    @Column(name = "target")
    // 지원대상
    private String address;

    @Column(name = "content")
    // 지원내용
    private String content;

    @Column(name = "terms")
    // 지원조건
    private String  terms;

    @Column(name = "inquiry")
    // 문의
    private String inquiry;

    @Column(name = "period")
    // 지원 기간
    private String term;

    @Column(name = "organization")
    // 주체 기관
    private String agency;

    @Column(name = "type")
    // 지원사업유형
    private String type;

}
