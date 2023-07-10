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
public class WorkerFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_farm_id")
    // 농장-그룹ID
    private int workerFarmId;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    // 유저ID
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장그룹ID
    private Farm farm;


}
