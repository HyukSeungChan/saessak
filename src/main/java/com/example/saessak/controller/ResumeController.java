package com.example.saessak.controller;

import com.example.saessak.dto.ResumeRequestDto;
import com.example.saessak.dto.ResumeResponseDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.service.ResumeService;
import com.example.saessak.service.WorkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    // 이력서 생성
    @PostMapping("/resume")
    public ResponseEntity<ResumeRequestDto> save(@RequestBody ResumeRequestDto resumeRequestDto){
        resumeService.save(resumeRequestDto);
        return ResponseEntity.ok(resumeRequestDto);
    }

    // 자신의 이력서 확인
    @GetMapping("/resume")
    public ResponseEntity<ResumeResponseDto> findByUserUserId(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(resumeService.findByUserUserId(userId));
    }

}
