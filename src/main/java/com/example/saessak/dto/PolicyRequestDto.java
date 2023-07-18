package com.example.saessak.dto;

import com.example.saessak.entity.*;
import com.example.saessak.repository.FarmRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequestDto {

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

    public Policy toEntity() {
        return Policy.builder()
                .policyId(policyId)
                .name(name)
                .target(target)
                .content(content)
                .area(area)
                .terms(terms)
                .inquiry(inquiry)
                .term(term)
                .agency(agency)
                .type(type)
                .build();
    }

}
