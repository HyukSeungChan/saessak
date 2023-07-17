package com.example.saessak.controller;

import com.example.saessak.dto.PolicyRequestDto;
import com.example.saessak.dto.PolicyResponseDto;
import com.example.saessak.dto.WorkListResponseDto;
import com.example.saessak.entity.Policy;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    // 지원정책 생성
    @PostMapping("/policy")
    public ResponseEntity<PolicyRequestDto> save(@RequestBody PolicyRequestDto policyRequestDto) {
        policyService.save(policyRequestDto);
        return ResponseEntity.ok(policyRequestDto);
    }

    // 지원정책 조회
    @GetMapping("/policy")
    public ResponseEntity<ApiResponse> findAllByType(@RequestParam("type") String type) {
        System.out.println("지원정책 조회 입장!!");
        try {
            ResponseEntity.notFound();
            List<PolicyResponseDto> policy = policyService.findAllByType(type);
            System.out.println("find policy !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get policy successfully", policy));
        } catch (IllegalArgumentException e) {
            System.out.println("not policy !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found policy", null));
        }
    }

    // 해당 지원정책 조회
    @GetMapping("/policy/detail")
    public ResponseEntity<ApiResponse> findById(@RequestParam("policyId") int policyId) {
        System.out.println("해당 지원정책 조회 입장!!");
        try {
            ResponseEntity.notFound();
            PolicyResponseDto policy = policyService.findById(policyId);
            System.out.println("find policy !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get policy successfully", policy));
        } catch (IllegalArgumentException e) {
            System.out.println("not policy !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found policy", null));
        }
    }

}
