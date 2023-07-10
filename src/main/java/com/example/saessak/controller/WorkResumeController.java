package com.example.saessak.controller;


import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.service.WorkResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkResumeController {

    private final WorkResumeService workResumeService;

    // 도시농부 이력서 생성
    @PostMapping("/work/resume")
    public ResponseEntity<WorkResumeRequestDto> save(@RequestBody WorkResumeRequestDto workResumeRequestDto){
        workResumeRequestDto.setState("");
        workResumeService.save(workResumeRequestDto);
        return ResponseEntity.ok(workResumeRequestDto);
    }
}
