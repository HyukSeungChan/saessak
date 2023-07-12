package com.example.saessak.service;

import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Resume;
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

    // 일자리 공고 생성(농장주)
    @Transactional
    public Work save(WorkRequestDto workRequestDto){
        System.out.println("------ 일자리 공고 생성 ------");
        return workRepository.save(workRequestDto.toEntity());
    }

    // 일자리 공고 확인(농장주가 생성)
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmUserUserId(long userId) {
        System.out.println("------ 일자리 공고 확인(농장주가 생성한거) ------");
        List<Work> entity = workRepository.findAllByFarmUserUserId(userId);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }


    // 전체 일자리 공고 보기(노동자)
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAll() {
        System.out.println("------ 전체 일자리 공고 보기(노동자) ------");
        List<Work> entity = workRepository.findAll();
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }
    
    // 전체 일자리 공고 보기(노동자) 필터:지역
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmAddressContaining(String address) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:지역 ------");
        List<Work> entity = workRepository.findAllByFarmAddressContaining(address);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:농업구분
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmAgriculture(String agriculture) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:농업구분 ------");
        List<Work> entity = workRepository.findAllByFarmAgriculture(agriculture);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:희망작목
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmCrops(String crops) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:희망작목 ------");
        List<Work> entity = workRepository.findAllByFarmCrops(crops);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:경력
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByCareerContaining(String career) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:경력 ------");
        List<Work> entity = workRepository.findAllByCareerContaining(career);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 해당 일자리 공고 보기(노동자)
    @Transactional(readOnly = true)
    public WorkResponseDto findByWorkId(int workId) {
        System.out.println("------ 해당 일자리 공고 보기(노동자) ------");
        Work entity = workRepository.findByWorkId(workId);
        Farm farm = entity.getFarm();
        return new WorkResponseDto(entity, farm);
    }

    // 일자리 공고 검색(노동자)
    @Transactional(readOnly = true)
    public List<WorkResponseDto> searchWork(String keyword){
        System.out.println("------ 일자리 공고 검색(노동자) ------");
        List<Work> entity = workRepository.searchWork(keyword);
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }
}
