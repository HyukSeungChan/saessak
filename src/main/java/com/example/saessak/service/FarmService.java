package com.example.saessak.service;

import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Work;
import com.example.saessak.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;

    // 농장 생성
    @Transactional
    public Farm save(FarmRequestDto farmRequestDto, String fileUrl){
        System.out.println("------ 농장 생성 ------");
        fileUrl = fileUrl.replace("[", "").replace("]", "");
        farmRequestDto.setFarmImage(fileUrl);
        return farmRepository.save(farmRequestDto.toEntity());
    }
}
