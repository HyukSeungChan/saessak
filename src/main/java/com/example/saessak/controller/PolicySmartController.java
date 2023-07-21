package com.example.saessak.controller;

import com.example.saessak.dto.PolicySmartResponseDTO;
import com.example.saessak.dto.ReplyResponseDto;
import com.example.saessak.entity.PolicySmart;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.PolicySmartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class PolicySmartController {

    private final PolicySmartService policySmartService;

    // 스마트 농산사업 리스트 조회
    @GetMapping("/policy/smart")
    public ResponseEntity<ApiResponse> findAll() {
        System.out.println("해당 글의 댓글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<PolicySmartResponseDTO> policySmart = policySmartService.findAll();

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find reply !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get reply successfully", mapper.writeValueAsString(policySmart)));
        } catch (Exception e) {
            System.out.println("not reply !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get reply", null));
        }
    }
}
