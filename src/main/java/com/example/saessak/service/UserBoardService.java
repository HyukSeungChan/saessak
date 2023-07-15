package com.example.saessak.service;


import com.example.saessak.dto.UserBoardRequestDto;
import com.example.saessak.dto.UserBoardResponseDto;
import com.example.saessak.dto.UserTodoResponseDto;
import com.example.saessak.dto.UserWorkResponseDto;
import com.example.saessak.entity.UserBoard;
import com.example.saessak.entity.UserWork;
import com.example.saessak.repository.UserBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserBoardService {

    private final UserBoardRepository userBoardRepository;

    // 유저-글 즐겨찾기 저장
    @Transactional
    public UserBoard save(UserBoardRequestDto userBoardRequestDto){
        System.out.println("------ 유저-글 즐겨찾기 저장 ------");
        return userBoardRepository.save(userBoardRequestDto.toEntity());
    }

    // 유저-글 즐겨찾기 조회
    @Transactional(readOnly = true)
    public List<UserBoardResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 유저-일자리 즐겨찾기 조회 ------");
        List<UserBoard> entity = userBoardRepository.findAllByUserUserId(userId);
        return entity.stream().map(UserBoardResponseDto::new).collect(Collectors.toList());
    }

}
