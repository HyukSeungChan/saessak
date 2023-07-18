package com.example.saessak.service;

import com.example.saessak.dto.UserVideoRequestDto;
import com.example.saessak.dto.UserVideoWatchRequestDto;
import com.example.saessak.entity.User;
import com.example.saessak.entity.UserVideo;
import com.example.saessak.entity.UserVideoWatch;
import com.example.saessak.repository.UserRepository;
import com.example.saessak.repository.UserVideoWatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserVideoWatchService {

    private final UserVideoWatchRepository userVideoWatchRepository;

    private final UserRepository userRepository;

    // 유저가 비디오 다보면 저장
    @Transactional
    public UserVideoWatch save(UserVideoWatchRequestDto userVideoWatchRequestDto){
        System.out.println("------ 유저가 비디오 다보면 저장 ------");
        User user = userRepository.findById(userVideoWatchRequestDto.getUserId()).orElseThrow(()-> new IllegalArgumentException("유저가 없습니다."));
        user.setComplete(user.getComplete() + 1);
        return userVideoWatchRepository.save(userVideoWatchRequestDto.toEntity());
    }



}
