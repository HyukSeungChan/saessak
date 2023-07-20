package com.example.saessak.controller;

import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    private final AmazonS3Service amazonS3Service;

    // 농장 생성
    @PostMapping(value = "/farm")
    public ResponseEntity<ApiResponse> save(@RequestBody FarmRequestDto farmRequestDto) {
        farmService.save(farmRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","Post Created successfully", "good"));
//        return ResponseEntity.ok(farmRequestDto);
    }
}
