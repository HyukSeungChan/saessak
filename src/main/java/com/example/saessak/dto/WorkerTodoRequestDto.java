package com.example.saessak.dto;

import com.example.saessak.entity.Todo;
import com.example.saessak.entity.Worker;
import com.example.saessak.entity.WorkerTodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerTodoRequestDto {

    private int workerTodoId;
    private int workerId;
    private int todoId;

    public WorkerTodo toEntity() {
        Worker worker = Worker.builder().workerId(workerId).build();
        Todo todo = Todo.builder().todoId(todoId).build();

        return WorkerTodo.builder()
                .worker(worker)
                .todo(todo)
                .build();
    }

}
