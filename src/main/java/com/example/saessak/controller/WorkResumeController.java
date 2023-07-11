package com.example.saessak.controller;


import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.dto.WorkResumeResponseDto;
import com.example.saessak.service.WorkResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkResumeController {

    private final WorkResumeService workResumeService;

    // 도시농부 이력서 생성
    @PostMapping("/work/resume")
    public ResponseEntity<WorkResumeRequestDto> save(@RequestBody WorkResumeRequestDto workResumeRequestDto){
        workResumeRequestDto.setState("신청");
        workResumeService.save(workResumeRequestDto);
        return ResponseEntity.ok(workResumeRequestDto);
    }

//    @GetMapping("/work/resume")
//    // 해당 일자리에 신청한 이력서 전부 확인
//    public ResponseEntity<List<WorkResumeResponseDto>> findByWorkResume
}
