package com.example.saessak.dto;

import com.example.saessak.entity.PolicyAgriculture;
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
public class PolicyAgricultureResponseDTO {

    private int policyAgricultureId;

    private String title;

    private String content;

    private String qualification;

    private String area;

    private String inquiry;

    private String note;

    public PolicyAgricultureResponseDTO(PolicyAgriculture policyAgriculture) {
        this.policyAgricultureId = policyAgriculture.getPolicyAgricultureId();
        this.title = policyAgriculture.getTitle();
        this.content = policyAgriculture.getContent();
        this.qualification = policyAgriculture.getQualification();
        this.area = policyAgriculture.getArea();
        this.inquiry = policyAgriculture.getInquiry();
        this.note = policyAgriculture.getNote();

    }

}
