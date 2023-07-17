package com.example.saessak.controller;

import com.example.saessak.dto.WorkerRequestDto;
import com.example.saessak.entity.Worker;
import com.example.saessak.payload.ApiResponse;

import com.example.saessak.service.WorkerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    // 노동자 생성
    @PostMapping(value = "/worker")
    public ResponseEntity<WorkerRequestDto> save(@RequestBody WorkerRequestDto workerRequestDto) {
        workerService.save(workerRequestDto);
        return ResponseEntity.ok(workerRequestDto);
    }

    // 노동자 받아오기
    @GetMapping("/worker")
    public ResponseEntity<ApiResponse> findWorker(@RequestParam("userId") Long userId) {
        System.out.println("노동자 받아오기 입장!!");
        try {
            ResponseEntity.notFound();
            Worker worker = workerService.findWorker(userId);
            System.out.println("find worker !!" + worker.getWorkerId());
            ObjectMapper mapper = new ObjectMapper();

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get worker successfully", mapper.writeValueAsString(worker)));
        } catch (IllegalArgumentException | JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("not worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "cant found worker", null));
        }
    }
}
