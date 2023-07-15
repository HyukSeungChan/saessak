package com.example.saessak.controller;


import com.example.saessak.dto.UserFarmResponseDto;
import com.example.saessak.dto.UserWorkRequestDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.dto.WorkResumeResponseDto;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.UserFarmService;
import com.example.saessak.service.UserWorkService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserFarmController {

    private final UserFarmService userFarmService;

    // 유저-농장 유저 조회
    @GetMapping("/user/farm")
    public ResponseEntity<ApiResponse> findAllByFarmFarmId(@RequestParam("farmId") int farmId){
        System.out.println("유저-농장 유저 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserFarmResponseDto> userFarm = userFarmService.findAllByFarmFarmId(farmId);
//            return ResponseEntity.ok(user);
            System.out.println("find user farm user !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user farm user successfully", userFarm));
        } catch (IllegalArgumentException e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user farm user", null));
        }
    }

    // 유저입장에서 자신이 속한 농장이 있는지 조회
    @GetMapping("/user/farm/group")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId){
        System.out.println("유저-농장 유저 조회 !!");
        try {
            ResponseEntity.notFound();
            List<UserFarmResponseDto> userFarm = userFarmService.findAllByUserUserId(userId);
//            return ResponseEntity.ok(user);
            System.out.println("find user farm user !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get user farm user successfully", userFarm));
        } catch (IllegalArgumentException e) {
            System.out.println("not work resume worker !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found user farm user", null));
        }
    }

    // 농장 나가기 중간에 (노동자)
    @DeleteMapping("/user/farm/exit")
    public ResponseEntity<Boolean> deleteByUserUserIdAndFarmFarmId(@RequestParam("userId") Long userId, @RequestParam("farmId") int farmId) {
        return ResponseEntity.ok(userFarmService.deleteByUserUserIdAndFarmFarmId(userId, farmId));
    }

    // 농장 나가기 기간만료 (노동자)
    @DeleteMapping("/user/farm/expiration")
    public ResponseEntity<Boolean> deleteUserFarmByUserUserIdAndDateEnd(@RequestParam("userId") Long userId, @RequestParam("dateEnd") String dateEnd) {
        return ResponseEntity.ok(userFarmService.deleteUserFarmByUserUserIdAndDateEnd(userId, dateEnd));
    }

}
