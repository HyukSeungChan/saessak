package com.example.saessak.service;

import com.example.saessak.dto.ResumeRequestDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.entity.WorkResume;
import com.example.saessak.repository.WorkResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkResumeService {

    private final WorkResumeRepository workResumeRepository;

    // 도시농부 이력서 생성
    @Transactional
    public WorkResume save(WorkResumeRequestDto workResumeRequestDto){
        System.out.println("------ 이력서 생성 ------");
        return workResumeRepository.save(workResumeRequestDto.toEntity());
    }

}
