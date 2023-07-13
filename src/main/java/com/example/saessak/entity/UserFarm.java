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
public class UserFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_farm_id")
    // 유저-농장ID
    private int userFarmId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장그룹ID
    private Farm farm;


}
