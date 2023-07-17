package com.example.saessak.controller;

import com.example.saessak.dto.ResumeResponseDto;
import com.example.saessak.dto.UserPolicyRequestDto;
import com.example.saessak.dto.UserPolicyResponseDto;
import com.example.saessak.entity.UserPolicy;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserPolicyController {

    private final UserPolicyService userPolicyService;

    // 유저-지원정책 즐겨찾기 생성
    @PostMapping("/user/policy/bookmark")
    public ResponseEntity<UserPolicyRequestDto> save(@RequestBody UserPolicyRequestDto userPolicyRequestDto) {
        userPolicyService.save(userPolicyRequestDto);
        return ResponseEntity.ok(userPolicyRequestDto);
    }

    // 유저-지원정책 즐겨찾기 조회
    @GetMapping("/user/policy/bookmark")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("유저-지원정책 즐겨찾기 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserPolicyResponseDto> userPolicy = userPolicyService.findAllByUserUserId(userId);
//            return ResponseEntity.ok(user);
            System.out.println("find user policy!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user policy successfully", userPolicy));
        } catch (IllegalArgumentException e) {
            System.out.println("not user policy !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user policy", null));
        }
    }
}
