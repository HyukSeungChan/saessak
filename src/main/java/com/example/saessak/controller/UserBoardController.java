package com.example.saessak.controller;


import com.example.saessak.dto.UserBoardRequestDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.dto.UserWorkRequestDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserBoardService;
import com.example.saessak.service.UserWorkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserBoardController {

    private final UserBoardService userBoardService;

    // 유저-글 즐겨찾기 저장
    @PostMapping("/user/board/bookmark")
    public ResponseEntity<UserBoardRequestDto> save(@RequestBody UserBoardRequestDto userBoardRequestDto){
        userBoardService.save(userBoardRequestDto);
        return ResponseEntity.ok(userBoardRequestDto);
    }

    // 유저-글 즐겨찾기 조회
    @GetMapping("/user/board/bookmark")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("유저-글 즐겨찾기 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserBoardResponseDto> userBoard = userBoardService.findAllByUserUserId(userId);

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find user board !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user board successfully", mapper.writeValueAsString(userBoard)));
        } catch (Exception e) {
            System.out.println("not user board !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user board", null));
        }
    }

    // 유저-글 즐겨찾기 삭제
    @DeleteMapping("/user/board/bookmark/delete")
    public int deleteByUserUserIdAndBoardBoardId(@RequestParam("userId") Long userId, @RequestParam("boardId") int boardId) {
        return userBoardService.deleteByUserUserIdAndBoardBoardId(userId, boardId);
    }
}
