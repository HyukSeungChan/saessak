package com.example.saessak.controller;

import com.example.saessak.dto.UserTodoFarmResponseDto;
import com.example.saessak.dto.UserTodoResponseDto;
import com.example.saessak.entity.UserTodo;
import com.example.saessak.entity.UserTodoFarm;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserTodoFarmService;
import com.example.saessak.service.UserTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserTodoFarmController {

    private final UserTodoFarmService userTodoFarmService;

    // 유저-할일-농장 생성 (농장주)
    @PostMapping("/user/todo/farm")
    public ResponseEntity<UserTodoFarm> save(@RequestParam("userId") List<Long> userId, @RequestParam("todoId") int todoId, @RequestParam("farmId") int farmId) {
        return ResponseEntity.ok(userTodoFarmService.save(userId, todoId, farmId));
    }

    // 할 일 조회(유저)
    @GetMapping("/user/todo")
    public ResponseEntity<ApiResponse> findAllByUserUserIdAndFarmFarmIdAndTodoDate(@RequestParam("userId") Long userId, @RequestParam("farmId") int farmId, @RequestParam("date") String date) {
        System.out.println("할 일 조회(유저) !!");
        try {
            ResponseEntity.notFound();
            List<UserTodoFarmResponseDto> userTodoFarm = userTodoFarmService.findAllByUserUserIdAndFarmFarmIdAndTodoDate(userId, farmId, date);
//            return ResponseEntity.ok(user);
            System.out.println("find user todo !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user todo successfully", userTodoFarm));
        } catch (IllegalArgumentException e) {
            System.out.println("not user todo !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user todo", null));
        }
    }

    // 할 일 조회 (농장주)
    @GetMapping("/todo/farm")
    public ResponseEntity<ApiResponse> findAllByFarmFarmIdAndTodoDate(@RequestParam("farmId") int farmId, @RequestParam("date") String date) {
        System.out.println("할 일 조회 (농장주) !!");
        try {
            ResponseEntity.notFound();
            List<UserTodoFarmResponseDto> userTodoFarm = userTodoFarmService.findAllByFarmFarmIdAndTodoDate(farmId, date);
//            return ResponseEntity.ok(user);
            System.out.println("find farm todo !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get farm todo successfully", userTodoFarm));
        } catch (IllegalArgumentException e) {
            System.out.println("not farm todo !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found farm todo", null));
        }
    }

}
