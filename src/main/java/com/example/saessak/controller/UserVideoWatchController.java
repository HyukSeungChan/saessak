package com.example.saessak.controller;


import com.example.saessak.dto.UserVideoRequestDto;
import com.example.saessak.dto.UserVideoResponseDto;
import com.example.saessak.dto.UserVideoWatchRequestDto;
import com.example.saessak.entity.UserVideoWatch;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserVideoService;
import com.example.saessak.service.UserVideoWatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserVideoWatchController {

    private final UserVideoWatchService userVideoWatchService;

    // 유저가 비디오 다보면 저장
    @PostMapping("/user/video/watch")
    public ResponseEntity<UserVideoWatchRequestDto> save(@RequestBody UserVideoWatchRequestDto userVideoWatchRequestDto){
        userVideoWatchService.save(userVideoWatchRequestDto);
        return ResponseEntity.ok(userVideoWatchRequestDto);
    }

}
