package com.example.saessak.controller;


import com.example.saessak.dto.UserWorkRequestDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.dto.WorkResumeResponseDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserWorkController {

    private final UserWorkService userWorkService;

    // 유저-일자리 즐겨찾기 저장
    @PostMapping("/user/work/bookmark")
    public ResponseEntity<UserWorkRequestDto> save(@RequestBody UserWorkRequestDto userWorkRequestDto){
        userWorkService.save(userWorkRequestDto);
        return ResponseEntity.ok(userWorkRequestDto);
    }

    // 유저-일자리 즐겨찾기 조회
    @GetMapping("/user/work/bookmark")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("유저-일자리 즐겨찾기 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserWorkResponseDto> userWork = userWorkService.findAllByUserUserId(userId);
//            return ResponseEntity.ok(user);
            System.out.println("find user work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user work successfully", null));
        } catch (IllegalArgumentException e) {
            System.out.println("not user work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user work", null));
        }
    }
}
