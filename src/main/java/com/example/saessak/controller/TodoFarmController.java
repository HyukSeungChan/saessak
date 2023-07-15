package com.example.saessak.controller;

import com.example.saessak.dto.TodoFarmRequestDto;
import com.example.saessak.dto.TodoFarmResponseDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.dto.UserTodoResponseDto;
import com.example.saessak.entity.TodoFarm;
import com.example.saessak.entity.UserTodo;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.TodoFarmService;
import com.example.saessak.service.UserTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TodoFarmController {

    private final TodoFarmService todoFarmService;

    // 할일-농장 생성
    @PostMapping("/todo/farm")
    public ResponseEntity<TodoFarmRequestDto> save(@RequestBody TodoFarmRequestDto todoFarmRequestDto) {
        todoFarmService.save(todoFarmRequestDto);
        return ResponseEntity.ok(todoFarmRequestDto);
    }

    // 할일-농장 조회
    @GetMapping("/todo/farm")
    public ResponseEntity<ApiResponse> findAllByFarmFarmId(int farmId) {
        System.out.println("할일-농장 조회 !!");
        try {
            ResponseEntity.notFound();
            List<TodoFarmResponseDto> userBoard = todoFarmService.findAllByFarmFarmId(farmId);
//            return ResponseEntity.ok(user);
            System.out.println("find todo farm!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get todo farmsuccessfully", userBoard));
        } catch (IllegalArgumentException e) {
            System.out.println("not todo farm !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found todo farm", null));
        }
    }

}
