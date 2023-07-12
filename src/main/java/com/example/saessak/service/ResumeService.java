package com.example.saessak.service;

import com.example.saessak.dto.ResumeRequestDto;
import com.example.saessak.dto.ResumeResponseDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.Work;
import com.example.saessak.repository.ResumeRepository;
import com.example.saessak.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    // 이력서 생성
    @Transactional
    public Resume save(ResumeRequestDto resumeRequestDto){
        System.out.println("------ 이력서 생성 ------");
        return resumeRepository.save(resumeRequestDto.toEntity());
    }

    // 자신의 이력서 확인
    @Transactional(readOnly = true)
    public ResumeResponseDto findByUserUserId(Long userId) {
        System.out.println("------ 자신의 이력서 확인 ------");
        Resume entity = resumeRepository.findByUserUserId(userId);
        return new ResumeResponseDto(entity);
    }

}
