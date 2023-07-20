//package com.example.saessak.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class UserPolicy {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_policy_id")
//    // 유저-지원정책ID
//    private int userPolicyId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    // 유저ID
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "policy_id")
//    // 지원정책ID
//    private PolicyAgriculture policy;
//}
