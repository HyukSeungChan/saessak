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
public class ReviewFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_farm_id")
    // 리뷰-농장ID
    private int reviewFarmId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    // 리뷰ID
    private Review review;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장그룹ID
    private Farm farm;
}
