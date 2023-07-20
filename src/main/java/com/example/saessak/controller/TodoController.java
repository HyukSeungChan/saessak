//package com.example.saessak.controller;
//
//import com.example.saessak.dto.TodoRequestDto;
//import com.example.saessak.dto.UserRequestDto;
//import com.example.saessak.dto.UserResponseDto;
//import com.example.saessak.service.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class TodoController {
//
//    private final TodoService todoService;
//
//    // 할일 생성
//    @PostMapping("/todo")
//    public ResponseEntity<TodoRequestDto> save(@RequestBody TodoRequestDto todoRequestDto) {
//        todoService.save(todoRequestDto);
//        return ResponseEntity.ok(todoRequestDto);
//    }
//
//}
