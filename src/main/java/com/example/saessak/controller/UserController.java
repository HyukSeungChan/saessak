package com.example.saessak.controller;

import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.UserResponseDto;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AmazonS3Service amazonS3Service;


    // 유저 생성
    @PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserRequestDto> save(@RequestPart("userRequestDto") UserRequestDto userRequestDto, @RequestPart("file") List<MultipartFile> multipartFiles) throws IOException {
        userService.save(userRequestDto, amazonS3Service.upload(multipartFiles).toString());
        return ResponseEntity.ok(userRequestDto);
    }

    // 해당 유저 정보 확인
    @GetMapping("/user")
    public ResponseEntity<UserResponseDto> findByUserId(@RequestParam("userId") String userId){
        return ResponseEntity.ok(userService.findByUserId(userId));
    }
}
