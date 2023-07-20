package com.example.saessak.dto;

import com.example.saessak.entity.PolicyAgriculture;
import com.example.saessak.entity.PolicySmart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicySmartResponseDTO {

    private int policySmartId;

    private String title;

    private String applyContent;

    private String type;

    private String outline;

    private String mainContent;

    public PolicySmartResponseDTO(PolicySmart policySmart) {
        this.policySmartId = policySmart.getPolicySmartId();
        this.title = policySmart.getTitle();
        this.applyContent = policySmart.getApplyContent();
        this.type = policySmart.getType();
        this.outline = policySmart.getOutline();
        this.mainContent = policySmart.getMainContent();
    }

}
