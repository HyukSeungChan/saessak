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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Work> entity = new ArrayList<>();

        if (address.contains(",")) {
            List<String> addressList = Arrays.asList(address.split(","));
            for (String addr : addressList) {
                List<Work> works = workRepository.findAllByFarmAddressContaining(addr.trim());
                entity.addAll(works);
            }
        } else {
            List<Work> works = workRepository.findAllByFarmAddressContaining(address.trim());
            entity.addAll(works);
        }
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:농업구분
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmAgricultureContaining(String agriculture) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:농업구분 ------");
        List<Work> entity = new ArrayList<>();

        if (agriculture.contains(",")) {
            List<String> agriList = Arrays.asList(agriculture.split(","));
            for (String agri : agriList) {
                List<Work> works = workRepository.findAllByFarmAgricultureContaining(agri.trim());
                entity.addAll(works);
            }
        } else {
            List<Work> works = workRepository.findAllByFarmAgricultureContaining(agriculture.trim());
            entity.addAll(works);
        }
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:희망작목
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByFarmCropsContaining(String crops) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:희망작목 ------");
        List<Work> entity = new ArrayList<>();

        if (crops.contains(",")) {
            List<String> cropsList = Arrays.asList(crops.split(","));
            for (String crop : cropsList) {
                List<Work> works = workRepository.findAllByFarmCropsContaining(crop.trim());
                entity.addAll(works);
            }
        } else {
            List<Work> works = workRepository.findAllByFarmCropsContaining(crops.trim());
            entity.addAll(works);
        }
        return entity.stream().map(work -> new WorkResponseDto(work, work.getFarm())).collect(Collectors.toList());
    }

    // 전체 일자리 공고 보기(노동자) 필터:경력
    @Transactional(readOnly = true)
    public List<WorkResponseDto> findAllByCareer(float career) {
        System.out.println("------ 전체 일자리 공고 보기(노동자) 필터:경력 ------");
        List<Work> entity = new ArrayList<>();

        if (career == 99) {
            entity = workRepository.findAll().stream().filter(work -> work.getCareer() == 99).collect(Collectors.toList());
        } else if (career<1) {
            entity = workRepository.findAll().stream().filter(work -> work.getCareer() < 1).collect(Collectors.toList());
        } else if (career<3) {
            entity = workRepository.findAll().stream().filter(work -> work.getCareer() < 3).collect(Collectors.toList());
        } else if (career<5) {
            entity = workRepository.findAll().stream().filter(work -> work.getCareer() < 5).collect(Collectors.toList());
        } else{
            entity = workRepository.findAll().stream().filter(work -> work.getCareer() >= 5).collect(Collectors.toList());
        }

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

    // 추천 일자리터
    @Transactional(readOnly = true)
    public List<WorkResponseDto> workRecommend(String address, String agriculture, String crops) {
        System.out.println("------ 추천 일자리터 ------");
        List<Work> entity = workRepository.findAll();

        if (address != null && !address.isEmpty()) {
            List<String> addressList = Arrays.asList(address.split(","));
            entity = entity.stream()
                    .filter(work -> containsAnyAddress(addressList, work.getFarm().getAddress()))
                    .collect(Collectors.toList());
        }

        if (agriculture != null && !agriculture.isEmpty()) {
            List<String> agricultureList = Arrays.asList(agriculture.split(","));
            entity = entity.stream()
                    .filter(work -> containsAnyItem(agricultureList, work.getFarm().getAgriculture()))
                    .collect(Collectors.toList());
        }

        if (crops != null && !crops.isEmpty()) {
            List<String> cropsList = Arrays.asList(crops.split(","));
            entity = entity.stream()
                    .filter(work -> containsAnyItem(cropsList, work.getFarm().getCrops()))
                    .collect(Collectors.toList());
        }

        return entity.stream()
                .map(work -> new WorkResponseDto(work, work.getFarm()))
                .collect(Collectors.toList());
    }

    // 주소 검색할 때 반점 있는 경우
    private boolean containsAnyAddress(List<String> addressList, String farmAddress) {
        for (String address : addressList) {
            if (farmAddress.contains(address)) {
                return true;
            }
        }
        return false;
    }

    // 농업구분, 농작물 검색할 때 반점 있는 경우
    private boolean containsAnyItem(List<String> itemList, String item) {
        for (String value : itemList) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
