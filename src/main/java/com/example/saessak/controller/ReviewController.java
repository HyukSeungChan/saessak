package com.example.saessak.controller;

import com.example.saessak.dto.*;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.BoardService;
import com.example.saessak.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    private final AmazonS3Service amazonS3Service;

    // 리뷰 생성
    @PostMapping(value = "/review", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ReviewRequestDto> save(@RequestPart("reviewRequestDto") ReviewRequestDto reviewRequestDto, @RequestPart(value = "file", required = false) List<MultipartFile> multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            reviewService.save(reviewRequestDto, amazonS3Service.upload(multipartFile).toString());
        } else {
            reviewService.save(reviewRequestDto);
        }
        return ResponseEntity.ok(reviewRequestDto);
    }

    // 리뷰 조회
    @GetMapping("/review")
    public ResponseEntity<ApiResponse> findAllByFarmFarmId(@RequestParam("farmId") int farmId) {
        System.out.println("리뷰 조회 !!");
        try {
            ResponseEntity.notFound();
            List<ReviewResponseDto> review = reviewService.findAllByFarmFarmId(farmId);

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find review !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get review successfully", mapper.writeValueAsString(review)));
        } catch (Exception e) {
            System.out.println("not review !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get review", null));
        }
    }

}
