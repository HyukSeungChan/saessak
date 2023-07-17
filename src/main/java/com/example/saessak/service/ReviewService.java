package com.example.saessak.service;

import com.example.saessak.dto.BoardRequestDto;
import com.example.saessak.dto.ReviewRequestDto;
import com.example.saessak.dto.ReviewResponseDto;
import com.example.saessak.entity.Board;
import com.example.saessak.entity.Review;
import com.example.saessak.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 생성 사진 있을 때
    @Transactional
    public Review save(ReviewRequestDto reviewRequestDto, String fileUrl) {
        System.out.println("------ 리뷰 생성 ------");
        if (fileUrl != null) {
            fileUrl = fileUrl.replace("[", "").replace("]", "");
        }
        reviewRequestDto.setImage(fileUrl);
        return reviewRepository.save(reviewRequestDto.toEntity());
    }

    // 리뷰 생성 사진 없을 때
    @Transactional
    public Review save(ReviewRequestDto reviewRequestDto) {
        System.out.println("------ 리뷰 생성 ------");
        return reviewRepository.save(reviewRequestDto.toEntity());
    }

    // 리뷰 조회
    @Transactional(readOnly = true)
    public List<ReviewResponseDto> findAllByFarmFarmId(int farmId) {
        System.out.println("------ 리뷰 조회 ------");
        List<Review> entity = reviewRepository.findAllByFarmFarmId(farmId);
        return entity.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }
}
