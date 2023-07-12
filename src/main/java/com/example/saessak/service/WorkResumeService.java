package com.example.saessak.service;

import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.dto.WorkResumeResponseDto;
import com.example.saessak.entity.Work;
import com.example.saessak.entity.WorkResume;
import com.example.saessak.repository.ResumeRepository;
import com.example.saessak.repository.WorkResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkResumeService {

    private final WorkResumeRepository workResumeRepository;

    // 이력서 생성(도시농부)
    @Transactional
    public WorkResume save(WorkResumeRequestDto workResumeRequestDto){
        System.out.println("------ 이력서 생성 ------");
        return workResumeRepository.save(workResumeRequestDto.toEntity());
    }

    // 이력서 리스트 조회(도시농부)
    @Transactional(readOnly = true)
    public List<WorkResumeResponseDto> findAllByResumeUserUserId(Long userId) {
        System.out.println("------ 도시농부 이력서 확인 ------");
        List<WorkResume> entity = workResumeRepository.findAllByResumeUserUserId(userId);
        return entity.stream().map(WorkResumeResponseDto::new).collect(Collectors.toList());
    }

    // 접수된 이력서 리스트 조회(농장주)
    @Transactional(readOnly = true)
    public List<WorkResumeResponseDto>  findAllByWorkFarmUserUserId(Long userId) {
        System.out.println("------ 농장주 접수된 이력서 리스트 확인 ------");
        List<WorkResume> entity = workResumeRepository.findAllByWorkFarmUserUserId(userId);
        return entity.stream().map(WorkResumeResponseDto::new).collect(Collectors.toList());
    }

    // 접수된 해당 이력서 확인(농장주)
    @Transactional
    public WorkResumeResponseDto findByWorkResumeId(int workResumeId) {
        System.out.println("------ 농장주 접수된 이력서 확인 ------");
        WorkResume entity = workResumeRepository.findByWorkResumeId(workResumeId);
        entity.setState("열람");
        return new WorkResumeResponseDto(entity);
    }

}
