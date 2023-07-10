package com.example.saessak.controller;

import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.dto.WorkerRequestDto;
import com.example.saessak.service.WorkService;
import com.example.saessak.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    // 노동자 생성
    @PostMapping(value = "/worker")
    public ResponseEntity<WorkerRequestDto> save(@RequestBody WorkerRequestDto workerRequestDto) {
        workerService.save(workerRequestDto);
        return ResponseEntity.ok(workerRequestDto);
    }
}
