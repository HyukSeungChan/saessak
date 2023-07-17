package com.example.saessak.service;

import com.example.saessak.dto.PolicyRequestDto;
import com.example.saessak.dto.PolicyResponseDto;
import com.example.saessak.dto.ReplyResponseDto;
import com.example.saessak.entity.Policy;
import com.example.saessak.entity.Reply;
import com.example.saessak.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;

    // 지원정책 생성
    @Transactional
    public Policy save(PolicyRequestDto policyRequestDto) {
        return policyRepository.save(policyRequestDto.toEntity());
    }

    // 지원정책 조회
    @Transactional(readOnly = true)
    public List<PolicyResponseDto> findAllByType(String type) {
        List<Policy> entity = policyRepository.findAllByType(type);
        return entity.stream().map(PolicyResponseDto::new).collect(Collectors.toList());
    }

    // 해당 지원정책 조회
    @Transactional(readOnly = true)
    public PolicyResponseDto findById(int policyId) {
        Policy entity = policyRepository.findById(policyId).orElseThrow(() -> new IllegalArgumentException("해당 지원정책이 없습니다"));
        return new PolicyResponseDto(entity);
    }

    // 귀농귀촌 지원 필터링(지역)
}
