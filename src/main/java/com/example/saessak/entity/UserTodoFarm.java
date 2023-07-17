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
public class UserTodoFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_todo_farm_id")
    // 유저-할일-농장ID
    private int userTodoFarmId;

//    @Column(name = "date")
//    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    // 할일ID
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    // 농장ID
    private Farm farm;


}
