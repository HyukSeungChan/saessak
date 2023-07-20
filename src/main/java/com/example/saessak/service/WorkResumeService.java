package com.example.saessak.service;

import com.example.saessak.dto.*;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.Work;
import com.example.saessak.entity.WorkResume;
import com.example.saessak.entity.UserFarm;
import com.example.saessak.repository.ResumeRepository;
import com.example.saessak.repository.WorkRepository;
import com.example.saessak.repository.WorkResumeRepository;
import com.example.saessak.repository.UserFarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkResumeService {

    private final WorkResumeRepository workResumeRepository;

    private final WorkRepository workRepository;

    private final ResumeRepository resumeRepository;

    private final UserFarmRepository userFarmRepository;

    // 이력서 생성(도시농부)
    @Transactional
    public WorkResume save(WorkResumeRequestDto workResumeRequestDto){
        System.out.println("------ 이력서 생성 ------");
        Work entity = workRepository.findById(workResumeRequestDto.getWorkId()).orElseThrow(()->new IllegalArgumentException("일자리가 없습니다"));
        workResumeRequestDto.setDate(entity.getRecruitmentEnd());
        return workResumeRepository.save(workResumeRequestDto.toEntity());
    }

    // 이력서 리스트 조회(도시농부)
    @Transactional(readOnly = true)
    public List<WorkResumeResponseWorkerDto> findAllByResumeUserUserId(Long userId) {
        System.out.println("------ 이력서 리스트 조회(도시농부) ------");
        List<WorkResume> entity = workResumeRepository.findAllByResumeUserUserId(userId);
        return entity.stream().map(WorkResumeResponseWorkerDto::new).collect(Collectors.toList());
    }

    // 지원취소 (도시농부)
    @Transactional
    public WorkResumeResponseDto applyCancel(int workResumeId) {
        WorkResume entity = workResumeRepository.findByWorkResumeId(workResumeId);
        entity.setState("지원취소");
        return new WorkResumeResponseDto(entity);
    }

    // 접수된 이력서 리스트 조회(농장주)
    @Transactional(readOnly = true)
    public List<WorkResumeResponseDto>  findAllByWorkFarmUserUserId(Long userId) {
        System.out.println("------ 접수된 이력서 리스트 조회(농장주) ------");
        List<WorkResume> entity = workResumeRepository.findAllByWorkFarmUserUserId(userId);
        return entity.stream().map(WorkResumeResponseDto::new).collect(Collectors.toList());
    }

    // 접수된 해당 이력서 확인(농장주)
    @Transactional
    public WorkResumeResponseDto findByWorkResumeId(int workResumeId) {
        System.out.println("------ 접수된 해당 이력서 확인(농장주) ------");
        WorkResume entity = workResumeRepository.findByWorkResumeId(workResumeId);
        entity.setState("열람");
        return new WorkResumeResponseDto(entity);
    }

    // 이력서 승인(농장주)
    @Transactional
    public WorkResumeResponseDto updateState(int workResumeId) {
        System.out.println("------ 이력서 승인(농장주) ------");
        WorkResume entity = workResumeRepository.findByWorkResumeId(workResumeId);
        entity.setState("승인완료");

        if (entity.getState().equals("승인완료")) {
            UserFarm userFarm = UserFarm.builder()
                    .user(entity.getResume().getUser())
                    .dateStart(entity.getResume().getWorkStartDay())
                    .dateEnd(entity.getResume().getWorkEndDay())
                    .farm(entity.getWork().getFarm())
                    .build();
            userFarmRepository.save(userFarm);
        }

        return new WorkResumeResponseDto(entity);
    }

}
