package com.example.saessak.service;

import com.example.saessak.dto.BoardResponseDto;
import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.VideoRequestDto;
import com.example.saessak.dto.VideoResponseDto;
import com.example.saessak.entity.Board;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Video;
import com.example.saessak.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    // 영상 생성
    @Transactional
    public Video save(VideoRequestDto videoRequestDto, String fileUrl){
        System.out.println("------ 영상 생성 ------");
        fileUrl = fileUrl.replace("[", "").replace("]", "");
        videoRequestDto.setLink(fileUrl);
        return videoRepository.save(videoRequestDto.toEntity());
    }

    // 타입에 따른 영상 리스트 조회
    @Transactional(readOnly = true)
    public List<VideoResponseDto> findAllByType(String type) {
        System.out.println("------ 타입에 따른 영상 리스트 조회 ------");
        List<Video> entity = videoRepository.findAllByType(type);
        return entity.stream().map(VideoResponseDto::new).collect(Collectors.toList());
    }

    // 해당 영상 조회
    @Transactional(readOnly = true)
    public VideoResponseDto findById(int videoId) {
        System.out.println("------ 해당 영상 조회 ------");
        Video entity = videoRepository.findById(videoId).orElseThrow(()->new IllegalArgumentException("해당 영상이 없습니다."));
        return new VideoResponseDto(entity);
    }


}
