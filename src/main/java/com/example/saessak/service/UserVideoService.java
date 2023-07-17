package com.example.saessak.service;


import com.example.saessak.dto.UserBoardRequestDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.dto.UserVideoRequestDto;
import com.example.saessak.dto.UserVideoResponseDto;
import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserVideo;
import com.example.saessak.repository.UserBoardRepository;
import com.example.saessak.repository.UserVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserVideoService {

    private final UserVideoRepository userVideoRepository;

    // 유저-비디오 즐겨찾기 저장
    @Transactional
    public UserVideo save(UserVideoRequestDto userVideoRequestDto){
        System.out.println("------ 유저-비디오 즐겨찾기 저장 ------");
        return userVideoRepository.save(userVideoRequestDto.toEntity());
    }

    // 유저-비디오 즐겨찾기 조회
    @Transactional(readOnly = true)
    public List<UserVideoResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 유저-비디오 즐겨찾기 조회 ------");
        List<UserVideo> entity = userVideoRepository.findAllByUserUserId(userId);
        return entity.stream().map(UserVideoResponseDto::new).collect(Collectors.toList());
    }

}
