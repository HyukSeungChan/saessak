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
public class UserSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_support_id")
    // 유저-지원정책ID
    private int userSupportId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "support_id")
    // 지원정책ID
    private Support support;
}
