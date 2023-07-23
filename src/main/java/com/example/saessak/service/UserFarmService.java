package com.example.saessak.service;

import com.example.saessak.dto.*;
import com.example.saessak.entity.UserFarm;
import com.example.saessak.entity.UserTodoFarm;
import com.example.saessak.repository.UserFarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFarmService {

    private final UserFarmRepository userFarmRepository;


    // 유저-농장 유저 조회
    @Transactional(readOnly = true)
    public List<UserFarmResponseDto> findAllByFarmFarmId(int farmId) {
        System.out.println("------ 유저-농장 유저 조회 ------");
        List<UserFarm> entity = userFarmRepository.findAllByFarmFarmId(farmId);
        return entity.stream().map(userFarm -> new UserFarmResponseDto(userFarm, userFarm.getUser(), userFarm.getFarm())).collect(Collectors.toList());
    }



    // 농장 나가기 중간에 (노동자)
    @Transactional
    public Boolean deleteByUserUserIdAndFarmFarmId(Long userId, int farmId) {
        UserFarm userFarm = userFarmRepository.findByUserUserIdAndFarmFarmId(userId, farmId);
        if (userFarm != null) {
            userFarmRepository.deleteByUserUserIdAndFarmFarmId(userId, farmId);
            return true;
        } else {
            return false;
        }

    }

    // 농장 나가기 기간만료 (노동자)
    @Transactional
    public Boolean deleteUserFarmByUserUserIdAndDateEnd(Long userId, String dateEnd) {
        UserFarm userFarm = userFarmRepository.findByUserUserIdAndDateEnd(userId, dateEnd);
        if (userFarm != null) {
            userFarmRepository.deleteUserFarmByUserUserIdAndDateEnd(userId, dateEnd);
            return true;
        } else {
            return false;
        }
    }

    // 유저입장에서 자신이 속한 농장이 있는지 조회
    @Transactional(readOnly = true)
    public List<UserFarmResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 유저입장에서 자신이 속한 농장이 있는지 조회 ------");
        List<UserFarm> entity = userFarmRepository.findAllByUserUserId(userId);
        return entity.stream().map(userFarm -> new UserFarmResponseDto(userFarm, userFarm.getUser(), userFarm.getFarm())).collect(Collectors.toList());

    }

}
