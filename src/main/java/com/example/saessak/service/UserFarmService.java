package com.example.saessak.service;

import com.example.saessak.dto.*;
import com.example.saessak.entity.UserFarm;
import com.example.saessak.repository.UserFarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFarmService {

    private final UserFarmRepository userFarmRepository;


    // 유저-농장 유저 조회
    @Transactional(readOnly = true)
    public List<UserFarmResponseDto> findAllByFarmFarmId(int farmId) {
        System.out.println("------ 유저-농장 유저 조회 ------");
        List<UserFarm> entity = userFarmRepository.findAllByFarmFarmId(farmId);
        return entity.stream().map(userFarm -> new UserFarmResponseDto(userFarm, userFarm.getUser())).collect(Collectors.toList());
    }

    // 유저입장에서 자신이 속한 농장이 있는지 조회
    @Transactional(readOnly = true)
    public List<UserFarmResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 유저입장에서 자신이 속한 농장이 있는지 조회 ------");
        List<UserFarm> entity = userFarmRepository.findAllByUserUserId(userId);
        return entity.stream().map(userFarm -> new UserFarmResponseDto(userFarm, userFarm.getUser())).collect(Collectors.toList());

    }
}
