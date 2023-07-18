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
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farm_id")
    // 농장 ID
    private int farmId;

    @Column(name = "name")
    // 농장 이름
    private String name;

    @Column(name = "address")
    // 농장 주소
    private String address;

    @Column(name = "farm_image")
    // 농장 사진
    private String farmImage;

    @Column(name = "pay")
    // 일급
    private int pay;

    @Column(name = "phone")
    // 농장 전화번호
    private String phone;

    @Column(name = "introduction", length = 1024)
    // 농장 상세 설명, 필수x
    private String introduction;

    @Column(name = "agriculture")
    // 농업 구분
    private String agriculture;

    @Column(name = "crops")
    // 작목 구분
    private String crops;

    @Column(name = "crops_detail")
    // 작목 상세정보
    private String crops_detail;

    @OneToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @OneToMany(mappedBy = "farm")
    // mapping
    private List<UserFarm> userFarms = new ArrayList<>();

    @OneToMany(mappedBy = "farm")
    // mapping
    private List<UserTodoFarm> userTodoFarms = new ArrayList<>();

}
