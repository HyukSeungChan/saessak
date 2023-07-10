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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    // 노동자ID
    private int workerId;

    @Column(name = "certificate")
    // 수료증
    private String certificate;

    @Column(name = "area")
    // 희망위치
    private String area;

    @Column(name = "agriculture")
    // 희망농업
    private String agriculture;

    @Column(name = "pay")
    // 희망시급
    private String pay;

    @Column(name = "crops")
    // 희망작물
    private String crops;

    @Column(name = "interest_crops")
    // 관심 농작물
    private String interestCrops;

    @Column(name = "badge")
    // 뱃지
    private String badge;

    @OneToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @OneToMany(mappedBy = "worker")
    // mapping
    private List<WorkerFarm> workerFarms = new ArrayList<>();

    @OneToMany(mappedBy = "worker")
    // mapping
    private List<WorkerTodo> workerTodos = new ArrayList<>();

}
