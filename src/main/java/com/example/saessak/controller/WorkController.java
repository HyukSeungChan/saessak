package com.example.saessak.controller;

import com.example.saessak.dto.UserResponseDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Work;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    // 일자리 공고 확인(농장주가 생성)
//    @GetMapping("/work/farm")
//    public ResponseEntity<List<WorkResponseDto>> findByFarm(@RequestParam("farmId") int farmId) {
//        return ResponseEntity.ok(workService.findAllByFarm(farmId));
//    }

    // 일자리 공고 확인(농장주가 생성)
    @GetMapping("/work/farm")
    public ResponseEntity<ApiResponse> findAllByFarmUserUserId(@RequestParam("userId") long userId) {
        System.out.println("일자리 공고 확인(농장주가 생성) 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmUserUserId(userId);
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자)
    @GetMapping("/work/worker/all")
    public ResponseEntity<ApiResponse> findAll() {
        System.out.println("전체 일자리 공고 보기(노동자) 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAll();
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:지역
    @GetMapping("/work/worker/all/address")
    public ResponseEntity<ApiResponse> findAllByFarmAddressContaining(@RequestParam("address") String address) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:지역 입장!!");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmAddressContaining(address);
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:농업구분
    @GetMapping("/work/worker/all/agriculture")
    public ResponseEntity<ApiResponse> findAllByFarmAgriculture(@RequestParam("agriculture") String agriculture) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:농업구분");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmAgriculture(agriculture);
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:희망작목
    @GetMapping("/work/worker/all/crops")
    public ResponseEntity<ApiResponse> findAllByFarmCrops(@RequestParam("crops") String crops) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:희망작목");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByFarmCrops(crops);
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }

    // 전체 일자리 공고 보기(노동자) 필터:경력
    @GetMapping("/work/worker/all/career")
    public ResponseEntity<ApiResponse> findAllByCareerContaining(@RequestParam("career") String career) {
        System.out.println("전체 일자리 공고 보기(노동자) 필터:경력");
        try {
            ResponseEntity.notFound();
            List<WorkResponseDto> work = workService.findAllByCareerContaining(career);
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
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
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
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
            System.out.println("find work !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get work successfully", work));
        } catch (IllegalArgumentException e) {
            System.out.println("not work !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found work", null));
        }
    }
}
