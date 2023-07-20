package com.example.saessak.controller;


import com.example.saessak.dto.*;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.WorkResumeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkResumeController {

    private final WorkResumeService workResumeService;

    // 이력서 생성(도시농부)
    @PostMapping("/work/resume")
    public ResponseEntity<WorkResumeRequestDto> save(@RequestBody WorkResumeRequestDto workResumeRequestDto){
        workResumeRequestDto.setState("미열람");
        workResumeService.save(workResumeRequestDto);
        return ResponseEntity.ok(workResumeRequestDto);
    }

    // 이력서 리스트 조회(도시농부)
    @GetMapping("/work/resume/worker")
    public ResponseEntity<ApiResponse> findAllByResumeResumeId(@RequestParam("userId") Long userId) {
        System.out.println("이력서 리스트 조회(도시농부) !!");
        try {
            ResponseEntity.notFound();
            List<WorkResumeResponseWorkerDto> workResume = workResumeService.findAllByResumeUserUserId(userId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find work resume worker !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work resume worker successfully", mapper.writeValueAsString(workResume)));
        } catch (Exception e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found work resume worker", null));
        }
    }

    // 지원취소 (도시농부)
    @GetMapping("work/resume/worker/delete")
    public ResponseEntity<ApiResponse> applyCancel(@RequestParam("workResumeId") int workResumeId) {
        System.out.println("지원취소 (도시농부)!!");
        try {
            ResponseEntity.notFound();
            WorkResumeResponseDto workResume = workResumeService.applyCancel(workResumeId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find work resume worker !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work resume worker successfully", mapper.writeValueAsString(workResume)));
        } catch (Exception e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found work resume worker", null));
        }
    }

    // 접수된 이력서 리스트 조회(농장주)
    @GetMapping("work/resume/farm")
    public ResponseEntity<ApiResponse> findAllByWorkFarmUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("접수된 이력서 리스트 조회(농장주) !!");
        try {
            ResponseEntity.notFound();
            List<WorkResumeResponseDto> workResume = workResumeService.findAllByWorkFarmUserUserId(userId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find work resume worker !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work resume worker successfully", mapper.writeValueAsString(workResume)));
        } catch (Exception e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found work resume worker", null));
        }
    }

    @GetMapping("/work/resume/farm/detail")
    // 접수된 해당 이력서 확인(농장주)
    public ResponseEntity<ApiResponse> findByWorkResumeId(@RequestParam("workResumeId") int workResumeId) {
        System.out.println("접수된 해당 이력서 확인(농장주)!!");
        try {
            ResponseEntity.notFound();
            WorkResumeResponseDto workResume = workResumeService.findByWorkResumeId(workResumeId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find work resume worker !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work resume worker successfully", mapper.writeValueAsString(workResume)));
        } catch (Exception e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found work resume worker", null));
        }
    }

    // 이력서 승인(농장주)
    @GetMapping("/work/resume/farm/detail/state")
    public ResponseEntity<ApiResponse> updateState(@RequestParam("workResumeId") int workResumeId) {
        System.out.println("이력서 승인(농장주) !!");
        try {
            ResponseEntity.notFound();
            WorkResumeResponseDto workResume = workResumeService.updateState(workResumeId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find work resume worker !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work resume worker successfully", mapper.writeValueAsString(workResume)));
        } catch (Exception e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found work resume worker", null));
        }
    }


    // 이력서 관련 상태값 변경


}
