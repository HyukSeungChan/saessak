//package com.example.saessak.dto;
//
//import com.example.saessak.entity.UserPolicy;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserPolicyResponseDto {
//
//    private int userPolicyId;
//    private Long userId;
//    private int policyId;
//
//    // 지원정책
//    private String name;
//    private String target;
//    private String content;
//
//    public UserPolicyResponseDto(UserPolicy userPolicy) {
//        this.userPolicyId = userPolicy.getUserPolicyId();
//        this.userId = userPolicy.getUser().getUserId();
////        this.policyId = userPolicy.getPolicy().getPolicyId();
//
////        this.name = userPolicy.getPolicy().getName();
////        this.target = userPolicy.getPolicy().getTarget();
//        this.content = userPolicy.getPolicy().getContent();
//
//    }
//
//}
