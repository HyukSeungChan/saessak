package com.example.saessak.controller;

import com.example.saessak.dto.UserTodoRequestDto;
import com.example.saessak.dto.UserTodoResponseDto;
import com.example.saessak.dto.UserWorkRequestDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.entity.UserTodo;
import com.example.saessak.payload.ApiResponse;
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
public class UserTodoController {

    private final UserTodoService userTodoService;

    // 유저에게 할 일 할당 (농장주)
//    @PostMapping("/user/todo")
//    public ResponseEntity<UserTodo> save(@RequestParam("userId") List<Long> userId, @RequestParam("todoId") int todoId) {
//        return ResponseEntity.ok(userTodoService.save(userId, todoId));
//    }

    // 할 일 조회(유저)
//    @GetMapping("/user/todo")
//    public ResponseEntity<ApiResponse> findAllByUserUserIdAndTodoDate(@RequestParam("userId") Long userId, @RequestParam("date") String date) {
//        System.out.println("할 일 조회(유저) !!");
//        try {
//            ResponseEntity.notFound();
//            List<UserTodoResponseDto> userTodo = userTodoService.findAllByUserUserIdAndTodoDate(userId, date);
////            return ResponseEntity.ok(user);
//            System.out.println("find user todo !!");
//            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user todo successfully", userTodo));
//        } catch (IllegalArgumentException e) {
//            System.out.println("not user todo !!");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user todo", null));
//        }
//    }

    // 할 일 조회 (농장주)


}
