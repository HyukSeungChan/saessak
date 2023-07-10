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
public class WorkerTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_todo_id")
    // 노동자-일감ID
    private int workerTodoId;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    // 노동자ID
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    // 일감ID
    private Todo todo;

}
