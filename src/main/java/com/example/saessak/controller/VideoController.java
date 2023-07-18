package com.example.saessak.controller;

import com.example.saessak.dto.BoardResponseDto;
import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.VideoRequestDto;
import com.example.saessak.dto.VideoResponseDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.UserVideoWatchService;
import com.example.saessak.service.VideoService;
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
public class VideoController {

    private final VideoService videoService;

    private final UserVideoWatchService userVideoWatchService;
    private final AmazonS3Service amazonS3Service;

    // 영상 생성
    @PostMapping(value = "/video", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<VideoRequestDto> save(@RequestPart("videoRequestDto") VideoRequestDto videoRequestDto, @RequestPart("file") MultipartFile multipartFile) throws IOException {
        videoService.save(videoRequestDto, amazonS3Service.upload(multipartFile).toString());
        return ResponseEntity.ok(videoRequestDto);
    }

    // 타입에 따른 영상 리스트 조회
    @GetMapping("/video")
    public ResponseEntity<ApiResponse> findAllByType(@RequestParam("type") String type) {
        System.out.println("타입에 따른 영상 리스트 조회 !!");
        try {
//            ResponseEntity.notFound();
            List<VideoResponseDto> video = videoService.findAllByType(type);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find video !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get video successfully", mapper.writeValueAsString(video)));
        } catch (Exception e) {
            System.out.println("not video !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get video", null));
        }
    }

    // 해당 영상 조회
    @GetMapping("/video/detail")
    public ResponseEntity<ApiResponse> findById(@RequestParam("videoId") int videoId) {
        System.out.println("해당 영상 조회 !!");
        try {
            ResponseEntity.notFound();
            VideoResponseDto video = videoService.findById(videoId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find video !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get video successfully", mapper.writeValueAsString(video)));
        } catch (Exception e) {
            System.out.println("not video !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get video", null));
        }
    }


    // 영상 보여주기
    @GetMapping("/video/watching")
    public ResponseEntity<ApiResponse> watchList(@RequestParam("userId") Long userId) {
        System.out.println("해당 영상 조회 !!");
        try {
            ResponseEntity.notFound();
            List<VideoResponseDto> video = videoService.watchList(userId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find video !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get video successfully", mapper.writeValueAsString(video)));
//            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get video successfully", video));
        } catch (Exception e) {
            System.out.println("not video !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get video", null));
        }
    }

}
