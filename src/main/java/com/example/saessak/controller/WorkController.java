package com.example.saessak.controller;

import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Work;
import com.example.saessak.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    // 일자리 공고 생성(농장주)
    @PostMapping("/work/farm")
    public ResponseEntity<WorkRequestDto> save(@RequestBody WorkRequestDto workRequestDto){
        workService.save(workRequestDto);
        return ResponseEntity.ok(workRequestDto);
    }

    // 일자리 공고 확인(농장주가 생성)
    @GetMapping("/work/farm")
    public ResponseEntity<List<WorkResponseDto>> findByFarm(@RequestParam("farmId") int farmId) {
        return ResponseEntity.ok(workService.findAllByFarm(farmId));
    }

    // 전체 일자리 공고 보기(노동자)
    @GetMapping("/work/worker")
    public ResponseEntity<List<WorkResponseDto>> findAll() {
        return ResponseEntity.ok(workService.findAll());
    }
}
