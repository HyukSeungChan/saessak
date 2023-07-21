package com.example.saessak.controller;

import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.FarmResponseDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.entity.Farm;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.FarmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    // 농장 조회
    @GetMapping("/farm")
    public ResponseEntity<ApiResponse> findById(@RequestParam("farmId") int farmId) {
        System.out.println("농장 조회 입장!!");
        try {
            ResponseEntity.notFound();
            FarmResponseDto farm = farmService.findById(farmId);
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("find policy !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get policy successfully", mapper.writeValueAsString(farm)));
        } catch (Exception e) {
            System.out.println("not policy !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found policy", null));
        }
    }



    @GetMapping("/user/farm/id")
    public ResponseEntity<ApiResponse> findByUserId(@RequestParam("userId") Long userId) {
        System.out.println("농장 조회 입장!!");
        try {
            ResponseEntity.notFound();
            FarmResponseDto farm = farmService.findByUserId(userId);
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("find policy !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get policy successfully", mapper.writeValueAsString(farm)));
        } catch (Exception e) {
            System.out.println("not policy !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found policy", null));
        }
    }
}
