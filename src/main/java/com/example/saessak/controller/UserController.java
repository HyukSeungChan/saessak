package com.example.saessak.controller;

import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.UserResponseDto;
import com.example.saessak.entity.User;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class UserController {

    private final UserService userService;
    private final AmazonS3Service amazonS3Service;


    // 유저 생성
    @PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserRequestDto> save(@RequestPart("userRequestDto") UserRequestDto userRequestDto, @RequestPart("file") MultipartFile multipartFile) throws IOException {
        System.out.println("회원가입!!");
        userService.save(userRequestDto, amazonS3Service.upload(multipartFile).toString());
        System.out.println("회원가입 완료!!");
        return ResponseEntity.ok(userRequestDto);
    }

    // 유저 카카오 생성
    @PostMapping(value = "/user/kakao")
    public ResponseEntity<ApiResponse> save(@RequestBody User user) {
        System.out.println("/user/kakao start!!");
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","Post Created successfully", user));
    }

    // 해당 유저 정보 확인
    @GetMapping("/user/info")
    public ResponseEntity<ApiResponse> findByUserId(@RequestParam("userId") Long userId){
        System.out.println("userinfo !!");
        try {
            ResponseEntity.notFound();
            UserResponseDto user = userService.findByUserId(userId);
//            return ResponseEntity.ok(user);
            System.out.println("find user !!");

//            JSONObject jsonObject = new JSONObject();
//            JSONParser parser = new JSONParser();

            ObjectMapper mapper = new ObjectMapper();

//            jsonObject = (JSONObject) parser.parse(user);

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","Post Created successfully", mapper.writeValueAsString(user)));
        } catch (IllegalArgumentException | JsonProcessingException e) {
            System.out.println("not user !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user", null));
        }
    }

    // 유저 탈퇴
    @DeleteMapping("/user/exit")
    public ResponseEntity<Boolean> deleteByUserId(@RequestParam("userId") Long userId) {
        System.out.println("userexit !!");
        return ResponseEntity.ok(userService.deleteByUserId(userId));
    }


}
