package com.example.saessak.service;

import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.UserResponseDto;
import com.example.saessak.entity.User;
import com.example.saessak.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    @Transactional
    public User save(UserRequestDto userRequestDto, String fileUrl) {
        System.out.println("------ 유저 생성 ------");
        fileUrl = fileUrl.replace("[", "").replace("]", "");
        userRequestDto.setProfileImage(fileUrl);
        return userRepository.save(userRequestDto.toEntity());
    }

    // 유저 생성
    @Transactional
    public User saveUser(User user) {
        System.out.println("------ 유저 생성 ------");
        System.out.println(user.getUserId() + ", " + user.getName() + ", " + user.getPhone() + ", " + user.getType());
        return userRepository.save(user);
    }

    // 해당 유저 정보 확인
    @Transactional(readOnly = true)
    public UserResponseDto findByUserId(Long userId) {
        System.out.println("------ 해당 유저 정보 확인 ------");
        User entity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        return new UserResponseDto(entity);
    }

    // 유저 탈퇴 -> 연관관계 이슈로 고민
    @Transactional
    public Boolean deleteByUserId(Long userId) {
        System.out.println("------ 유저 탈퇴 ------");
        userRepository.deleteByUserId(userId);
        return true;
    }

}
