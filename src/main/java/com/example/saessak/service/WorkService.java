package com.example.saessak.service;

import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Work;
import com.example.saessak.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;

    // 일자리 공고 생성
    @Transactional
    public Work save(WorkRequestDto workRequestDto){
        System.out.println("------ 일자리 공고 생성 ------");
        return workRepository.save(workRequestDto.toEntity());
    }

    // 전체 일자리 공고 보기
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAll() {
        List<Work> entity = workRepository.findAll();
        return entity.stream().map(WorkResponseDto::new).collect(Collectors.toList());
    }
}
