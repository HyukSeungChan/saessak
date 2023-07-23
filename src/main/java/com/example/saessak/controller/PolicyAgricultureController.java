package com.example.saessak.controller;

import com.example.saessak.dto.PolicyAgricultureResponseDTO;
import com.example.saessak.dto.PolicySmartResponseDTO;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.PolicyAgricultureService;
import com.example.saessak.service.PolicySmartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PolicyAgricultureController {

    private final PolicyAgricultureService policyAgricultureService;

    // 귀농귀촌 지업 리스트 조회
    @GetMapping("/policy/agriculture")
    public ResponseEntity<ApiResponse> findAll() {
        System.out.println("해당 글의 댓글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<PolicyAgricultureResponseDTO> policyAgriculture = policyAgricultureService.findAll();

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find reply !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get reply successfully", mapper.writeValueAsString(policyAgriculture)));
        } catch (Exception e) {
            System.out.println("not reply !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get reply", null));
        }
    }

    // 귀농귀촌 지업 해당 글 조회
    @GetMapping("/policy/agriculture/detail")
    public ResponseEntity<ApiResponse> findById(@RequestParam("policyAgricultureId") int policyAgricultureId) {
        System.out.println("해당 글의 댓글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            PolicyAgricultureResponseDTO policyAgriculture = policyAgricultureService.findById(policyAgricultureId);

            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find reply !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get reply successfully", mapper.writeValueAsString(policyAgriculture)));
        } catch (Exception e) {
            System.out.println("not reply !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get reply", null));
        }
    }
}
