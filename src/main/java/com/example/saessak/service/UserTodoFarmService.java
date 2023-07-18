package com.example.saessak.service;

import com.example.saessak.dto.TodoFarmRequestDto;
import com.example.saessak.dto.TodoFarmResponseDto;
import com.example.saessak.dto.UserTodoFarmRequestDto;
import com.example.saessak.dto.UserTodoFarmResponseDto;
import com.example.saessak.entity.TodoFarm;
import com.example.saessak.entity.UserFarm;
import com.example.saessak.entity.UserTodo;
import com.example.saessak.entity.UserTodoFarm;
import com.example.saessak.repository.TodoFarmRepository;
import com.example.saessak.repository.UserTodoFarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserTodoFarmService {

    private final UserTodoFarmRepository userTodoFarmRepository;

    // 유저-할일-농장 생성 (농장주)
    @Transactional
    public UserTodoFarm save(List<Long> userId, int todoId, int farmId) {
        System.out.println("------ 유저-할일-농장 생성 ------");
        UserTodoFarmRequestDto userTodoFarmRequestDto = new UserTodoFarmRequestDto();
        for (Long user : userId) {
            UserTodoFarm userTodoFarm = userTodoFarmRepository.save(userTodoFarmRequestDto.toEntity(user, todoId, farmId));
        }
        return new UserTodoFarm();
    }

    // 할 일 조회(유저)
    @Transactional(readOnly = true)
    public List<UserTodoFarmResponseDto> findAllByUserUserIdAndFarmFarmIdAndTodoDate(Long userId, int farmId, String date) {
        System.out.println("------ 할 일 조회(유저) ------");
        List<UserTodoFarm> entity = userTodoFarmRepository.findAllByUserUserIdAndFarmFarmIdAndTodoDate(userId, farmId, date);
        return entity.stream().map(userTodoFarm -> new UserTodoFarmResponseDto(userTodoFarm)).collect(Collectors.toList());
    }

    // 할 일 조회(유저)
    @Transactional(readOnly = true)
    public List<UserTodoFarmResponseDto> findAllByUserUserIdAndFarmFarmId(Long userId, int farmId) {
        System.out.println("------ 할 일 조회(유저) ------");
        List<UserTodoFarm> entity = userTodoFarmRepository.findAllByUserUserIdAndFarmFarmId(userId, farmId);
        return entity.stream().map(userTodoFarm -> new UserTodoFarmResponseDto(userTodoFarm)).collect(Collectors.toList());
    }

    // 할 일 조회(농장주)
    @Transactional(readOnly = true)
    public List<UserTodoFarmResponseDto> findAllByFarmFarmIdAndTodoDate(int farmId, String date) {
        System.out.println("------ 할 일 조회(농장주) ------");
        List<UserTodoFarm> entity = userTodoFarmRepository.findAllByFarmFarmIdAndTodoDate(farmId, date);
        return entity.stream().map(userTodoFarm -> new UserTodoFarmResponseDto(userTodoFarm, userTodoFarm.getUser())).collect(Collectors.toList());
    }
}
