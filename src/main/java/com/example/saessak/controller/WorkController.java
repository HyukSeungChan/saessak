package com.example.saessak.controller;

import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Work;
import com.example.saessak.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    // 일자리 공고 생성
    @PostMapping("/work")
    public ResponseEntity<WorkRequestDto> save(@RequestBody WorkRequestDto workRequestDto){
        workService.save(workRequestDto);
        return ResponseEntity.ok(workRequestDto);
    }

    // 전체 일자리 공고 보기
    @GetMapping("/work")
    public ResponseEntity<List<WorkResponseDto>> findAll() {
        return ResponseEntity.ok(workService.findAll());
    }
}
