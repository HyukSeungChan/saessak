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
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    // 일감ID
    private int todoId;

    @Column(name = "date")
    // 날짜
    private String date;

    @Column(name = "task")
    // 일감
    private String task;

    @OneToMany(mappedBy = "todo")
    // mapping
    private List<UserTodoFarm> userTodofarms = new ArrayList<>();
}
