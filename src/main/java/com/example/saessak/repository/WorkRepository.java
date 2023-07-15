package com.example.saessak.repository;

import com.example.saessak.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Integer> {
    // 전체 일자리 공고 보기(노동자)
    List<Work> findAll();

    // 일자리 공고 확인(농장주가 생성)
    List<Work> findAllByFarmUserUserId(Long userId);

    // 전체 일자리 공고 보기(노동자) 필터:지역
    List<Work> findAllByFarmAddressContaining(String address);

    // 전체 일자리 공고 보기(노동자) 필터:농업구분
    List<Work> findAllByFarmAgricultureContaining(String agriculture);

    // 전체 일자리 공고 보기(노동자) 필터:희망작목
    List<Work> findAllByFarmCropsContaining(String crops);

    // 해당 일자리 공고 보기(노동자)
    Work findByWorkId(int workId);

    // 일자리 공고 검색(노동자)
    @Query(value = "SELECT w FROM Work w WHERE w.title LIKE %:keyword% OR w.content LIKE %:keyword%")
    List<Work> searchWork(String keyword);


}
