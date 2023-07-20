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
    @PostMapping(value = "/farm", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<FarmRequestDto> save(@RequestPart("farmRequestDto") FarmRequestDto farmRequestDto, @RequestPart("file") MultipartFile multipartFile) throws IOException {
        farmService.save(farmRequestDto, amazonS3Service.upload(multipartFile).toString());
        return ResponseEntity.ok(farmRequestDto);
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
}
