//package com.example.saessak.service;
//
//import com.example.saessak.dto.UserBoardResponseDto;
//import com.example.saessak.dto.UserPolicyRequestDto;
//import com.example.saessak.dto.UserPolicyResponseDto;
//import com.example.saessak.entity.UserBoard;
//import com.example.saessak.entity.UserPolicy;
//import com.example.saessak.repository.UserPolicyRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class UserPolicyService {
//
//    private final UserPolicyRepository userPolicyRepository;
//
//    // 유저-지원정책 즐겨찾기 생성
//    @Transactional
//    public UserPolicy save(UserPolicyRequestDto userPolicyRequestDto) {
//        return userPolicyRepository.save(userPolicyRequestDto.toEntity());
//    }
//
//    // 유저-지원정책 즐겨찾기 조회
//    @Transactional(readOnly = true)
//    public List<UserPolicyResponseDto> findAllByUserUserId(Long userId) {
//        System.out.println("------ 유저-지원정책 즐겨찾기 조회 ------");
//        List<UserPolicy> entity = userPolicyRepository.findAllByUserUserId(userId);
//        return entity.stream().map(UserPolicyResponseDto::new).collect(Collectors.toList());
//    }
//
//    // 유저-지원정책 즐겨찾기 삭제
//    @Transactional
//    public int deleteByUserUserIdAndPolicyPolicyId(Long userId, int policyId) {
//        userPolicyRepository.deleteByUserUserIdAndPolicyPolicyId(userId, policyId);
//        return 1;
//    }
//
//}
