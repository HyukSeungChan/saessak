package com.example.saessak.controller;

import com.example.saessak.dto.*;
import com.example.saessak.entity.Board;
import com.example.saessak.entity.Work;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.WorkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    // 일자리 공고 생성(농장주)
    @PostMapping("/work/farm")
    public ResponseEntity<WorkRequestDto> save(@RequestBody WorkRequestDto workRequestDto){
        workService.save(workRequestDto);
        return ResponseEntity.ok(workRequestDto);
    }

    // 일자리 공고 확인(농장주가 생성)
    @GetMapping("/work/farm")
    public ResponseEntity<ApiResponse> findAllByFarmUserUserId(@RequestParam("userId") long userId) {
        System.out.println("일자리 공고 확인(농장주가 생성) 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmUserUserId(userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자)
    @GetMapping("/work/worker/all")
    public ResponseEntity<ApiResponse> findAll(@RequestParam("userId") Long userId) {
        System.out.println("전체 일자리 공고 보기(노동자) 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAll(userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:지역
    @GetMapping("/work/worker/address")
    public ResponseEntity<ApiResponse> findAllByFarmAddressContaining(@RequestParam ("address") String address, @RequestParam("userId") Long userId) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:지역 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmAddressContaining(address, userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:농업구분
    @GetMapping("/work/worker/agriculture")
    public ResponseEntity<ApiResponse> findAllByFarmAgricultureContaining(@RequestParam("agriculture") String agriculture, @RequestParam("userId") Long userId) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:농업구분");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmAgricultureContaining(agriculture, userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:희망작목
    @GetMapping("/work/worker/crops")
    public ResponseEntity<ApiResponse> findAllByFarmCrops(@RequestParam("crops") String crops, @RequestParam("userId") Long userId) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:희망작목");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmCropsContaining(crops, userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:경력
    @GetMapping("/work/worker/career")
    public ResponseEntity<ApiResponse> findAllByCareerContaining(@RequestParam("career") float career, @RequestParam("userId") Long userId) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:경력");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByCareer(career, userId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 해당 일자리 공고 보기(노동자)
    @GetMapping("work/worker/workId")
    public ResponseEntity<ApiResponse> findByWorkId(@RequestParam("workId") int workId) {
        System.out.println("해당 일자리 공고 보기(노동자)");
        try {
            ResponseEntity.notFound();
            WorkResponseDto work = workService.findByWorkId(workId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 일자리 공고 검색(노동자)
    @GetMapping("work/worker/search")
    public ResponseEntity<ApiResponse> searchWork(@RequestParam("keyword") String keyword) {
        System.out.println("일자리 공고 검색(노동자)");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.searchWork(keyword);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 추천 일자리터
    @GetMapping("work/recommend")
    public ResponseEntity<ApiResponse> workRecommend(@RequestParam("address") String address,
                                                     @RequestParam("agriculture") String agriculture,
                                                     @RequestParam("crops") String crops) {
        System.out.println("추천 일자리터");
        try {
            ResponseEntity.notFound();
            List<WorkRecommendResponseDto> work = workService.workRecommend(address, agriculture, crops);
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", mapper.writeValueAsString(work)));
        } catch (Exception e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

}
