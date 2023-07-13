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
public class TodoFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_farm_id")
    // 할일-농장ID
    private int todoFarmId;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    // 할일ID
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장그룹ID
    private Farm farm;
}
