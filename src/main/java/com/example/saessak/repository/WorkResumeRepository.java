package com.example.saessak.repository;

import com.example.saessak.entity.Work;
import com.example.saessak.entity.WorkResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkResumeRepository extends JpaRepository<WorkResume, Integer> {

    // 도시농부 이력서 리스트 확인
    List<WorkResume> findAllByResumeUserUserId(Long userId);

    // 농장주 접수된 이력서 리스트 확인
    List<WorkResume> findAllByWorkFarmUserUserId(Long userId);

    // 농장주 접수된 이력서 확인, 도시농부 접수한 이력서 확인
    WorkResume findByWorkResumeId(int workResumeId);

    // 일자리 확인
    WorkResume findByWorkWorkId(int workId);

}
