package com.example.saessak.service;

import com.example.saessak.dto.PolicyAgricultureResponseDTO;
import com.example.saessak.dto.PolicySmartResponseDTO;
import com.example.saessak.entity.PolicyAgriculture;
import com.example.saessak.entity.PolicySmart;
import com.example.saessak.repository.PolicyAgricultureRepository;
import com.example.saessak.repository.PolicySmartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicyAgricultureService {

    private final PolicyAgricultureRepository policyAgricultureRepository;

    // 귀농귀촌 지업 리스트 조회
    @Transactional(readOnly = true)
    public List<PolicyAgricultureResponseDTO> findAll() {
        System.out.println("------ 스마트 농산사업 리스트 조회 ------");
        List<PolicyAgriculture> entity = policyAgricultureRepository.findAll();
        return entity.stream().map(PolicyAgricultureResponseDTO::new).collect(Collectors.toList());
    }

    // 귀농귀촌 지업 리스트 조회
    public PolicyAgricultureResponseDTO findById(int policyAgricultureId) {
        System.out.println("------ 스마트 농산사업 해당 글 조회 ------");
        PolicyAgriculture entity = policyAgricultureRepository.findById(policyAgricultureId).orElseThrow(()->new IllegalArgumentException("해당 스마트 농산 사업이 없습니다."));
        return new PolicyAgricultureResponseDTO(entity);
    }
}
