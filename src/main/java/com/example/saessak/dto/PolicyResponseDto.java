package com.example.saessak.dto;

import com.example.saessak.entity.Policy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponseDto {

    private int policyId;

    // 지원사업명
    private String name;

    // 지원대상
    private String target;

    // 지원내용
    private String content;

    // 지역
    private String area;

    // 지원조건
    private String terms;

    // 문의
    private String inquiry;

    // 지원 기간
    private String term;

    // 주체 기관
    private String agency;

    // 지원사업유형
    private String type;

    public PolicyResponseDto(Policy policy) {
        this.policyId = policy.getPolicyId();
        this.name = policy.getName();
        this.target = policy.getTarget();
        this.content = policy.getContent();
        this.area = policy.getArea();
        this.terms = policy.getTerms();
        this.inquiry = policy.getInquiry();
        this.term = policy.getTerm();
        this.agency = policy.getAgency();
        this.type = policy.getType();
    }

}
