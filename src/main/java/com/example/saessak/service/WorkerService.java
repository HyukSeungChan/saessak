package com.example.saessak.service;

import com.example.saessak.dto.UserRequestDto;
import com.example.saessak.dto.WorkRequestDto;
import com.example.saessak.dto.WorkResponseDto;
import com.example.saessak.dto.WorkerRequestDto;
import com.example.saessak.entity.User;
import com.example.saessak.entity.Work;
import com.example.saessak.entity.Worker;
import com.example.saessak.repository.UserRepository;
import com.example.saessak.repository.WorkRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final UserRepository userRepository;

    // 노동자 생성
    @Transactional
    public Worker save(WorkerRequestDto workerRequestDto){
        System.out.println("------ 노동자 생성 ------");
        return workerRepository.save(workerRequestDto.toEntity());
    }

}
