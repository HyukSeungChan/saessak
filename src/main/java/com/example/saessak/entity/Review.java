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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    // 리뷰ID
    private int reviewId;

    @Column(name = "content")
    // 내용
    private String content;

    @Column(name = "image")
    // 사진
    private String image;

    @Column(name = "date_create")
    // 작성날짜
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장ID
    private Farm farm;

    @OneToMany(mappedBy = "review")
    // mapping
    private List<ReviewFarm> reviewFarms = new ArrayList<>();
}
