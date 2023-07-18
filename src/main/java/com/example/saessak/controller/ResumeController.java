package com.example.saessak.controller;

import com.example.saessak.dto.*;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.ResumeService;
import com.example.saessak.service.WorkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse> findByUserUserId(@RequestParam("userId") Long userId){
        System.out.println("자신의 이력서 확인 !!");
        try {
            ResponseEntity.notFound();
            ResumeResponseDto resume = resumeService.findByUserUserId(userId);

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find resume!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get resume successfully", mapper.writeValueAsString(resume)));
        } catch (Exception e) {
            System.out.println("not resume !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found resume", null));
        }
    }

    // 일자리에서 지원하기 눌렀을 때
    @GetMapping("/resume/work")
    public ResponseEntity<ApiResponse> workApply(@RequestParam("userId") Long userId){
        System.out.println("자신의 이력서 확인 !!");
        try {
            ResponseEntity.notFound();
            ResumeResponseDto resume = resumeService.workApply(userId);

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find resume!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get resume successfully", mapper.writeValueAsString(resume)));
        } catch (Exception e) {
            System.out.println("not resume !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found resume", null));
        }
    }

}
