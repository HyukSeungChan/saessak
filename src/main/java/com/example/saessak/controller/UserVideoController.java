package com.example.saessak.controller;


import com.example.saessak.dto.UserBoardRequestDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.dto.UserVideoRequestDto;
import com.example.saessak.dto.UserVideoResponseDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserBoardService;
import com.example.saessak.service.UserVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserVideoController {

    private final UserVideoService userVideoService;

    // 유저-글 즐겨찾기 저장
    @PostMapping("/user/video/bookmark")
    public ResponseEntity<UserVideoRequestDto> save(@RequestBody UserVideoRequestDto userVideoRequestDto){
        userVideoService.save(userVideoRequestDto);
        return ResponseEntity.ok(userVideoRequestDto);
    }

    // 유저-글 즐겨찾기 조회
    @GetMapping("/user/video/bookmark")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("유저-비디오 즐겨찾기 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserVideoResponseDto> userVideo = userVideoService.findAllByUserUserId(userId);
//            return ResponseEntity.ok(user);
            System.out.println("find user video !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user video successfully", userVideo));
        } catch (IllegalArgumentException e) {
            System.out.println("not user video !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user video", null));
        }
    }
}
