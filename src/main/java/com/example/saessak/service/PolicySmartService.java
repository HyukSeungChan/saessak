package com.example.saessak.service;

import com.example.saessak.dto.FarmResponseDto;
import com.example.saessak.dto.PolicySmartResponseDTO;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.PolicySmart;
import com.example.saessak.repository.PolicySmartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicySmartService {

    private final PolicySmartRepository policySmartRepository;

    // 스마트 농산사업 리스트 조회
    @Transactional(readOnly = true)
    public List<PolicySmartResponseDTO> findAll() {
        System.out.println("------ 농장 조회 ------");
        List<PolicySmart> entity = policySmartRepository.findAll();
        return entity.stream().map(PolicySmartResponseDTO::new).collect(Collectors.toList());
    }
}
