package com.example.saessak.service;

import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.FarmResponseDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Work;
import com.example.saessak.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;

    // 농장 생성
    @Transactional
    public Farm save(FarmRequestDto farmRequestDto){
        System.out.println("------ 농장 생성 ------");
//        fileUrl = fileUrl.replace("[", "").replace("]", "");
//        farmRequestDto.setFarmImage(fileUrl);
        return farmRepository.save(farmRequestDto.toEntity());
    }

    // 농장 조회
    @Transactional(readOnly = true)
    public FarmResponseDto findById(int farmId) {
        System.out.println("------ 농장 조회 ------");
        Farm entity = farmRepository.findById(farmId).orElseThrow(()->new IllegalArgumentException("해당 농장이 없습니다."));
        return new FarmResponseDto(entity);
    }

    // 농장 조회
    @Transactional(readOnly = true)
    public FarmResponseDto findByUserId(Long userId) {
        System.out.println("------ 농장 조회 ------");
        Farm entity = farmRepository.findByUserUserId(userId);
        return new FarmResponseDto(entity);
    }
}
