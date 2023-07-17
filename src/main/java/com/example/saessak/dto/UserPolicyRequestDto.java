package com.example.saessak.dto;

import com.example.saessak.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPolicyRequestDto {
    private Long userId;
    private int policyId;

    public UserPolicy toEntity() {
        User user = User.builder().userId(userId).build();
        Policy policy = Policy.builder().policyId(policyId).build();
        return UserPolicy.builder()
                .policy(policy)
                .user(user)
                .build();
    }

}
