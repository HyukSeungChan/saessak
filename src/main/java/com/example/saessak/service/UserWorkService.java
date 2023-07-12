package com.example.saessak.service;


import com.example.saessak.dto.UserWorkRequestDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.dto.WorkResumeRequestDto;
import com.example.saessak.dto.WorkResumeResponseDto;
import com.example.saessak.entity.UserWork;
import com.example.saessak.entity.WorkResume;
import com.example.saessak.repository.UserWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserWorkService {

    private final UserWorkRepository userWorkRepository;

    // 유저-일자리 즐겨찾기 저장
    @Transactional
    public UserWork save(UserWorkRequestDto userWorkRequestDto){
        System.out.println("------ 유저-일자리 즐겨찾기 저장 ------");
        return userWorkRepository.save(userWorkRequestDto.toEntity());
    }

    // 유저-일자리 즐겨찾기 조회
    @Transactional(readOnly = true)
    public List<UserWorkResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 유저-일자리 즐겨찾기 조회 ------");
        List<UserWork> entity = userWorkRepository.findAllByUserUserId(userId);
        return entity.stream().map(userWork -> new UserWorkResponseDto(userWork, userWork.getWork(), userWork.getWork().getFarm())).collect(Collectors.toList());
    }

}
