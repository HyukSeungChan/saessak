package com.example.saessak.service;

import com.example.saessak.dto.BoardResponseDto;
import com.example.saessak.dto.FarmRequestDto;
import com.example.saessak.dto.VideoRequestDto;
import com.example.saessak.dto.VideoResponseDto;
import com.example.saessak.entity.*;
import com.example.saessak.repository.UserVideoRepository;
import com.example.saessak.repository.UserVideoWatchRepository;
import com.example.saessak.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final UserVideoWatchRepository userVideoWatchRepository;

    private final UserVideoRepository userVideoRepository;

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


    public int saveWatch(int videoId, int userId) {
//        UserVideo userVideo = UserVideo.builder().userId(userId).videoId(videoId).build();
//        userVideoRepository.save(userVideo);
        return 1;
    }

    // 미시청 영상 보여주기


    // 시청 영상 보여주기
    @Transactional(readOnly = true)
    public List<VideoResponseDto> watchList(Long userId) {
        System.out.println("------ 시청 영상 보여주기 ------");
        List<UserVideoWatch> watched = userVideoWatchRepository.findAllByUserId(userId);
        List<UserVideo> bookmark = userVideoRepository.findAllByUserUserId(userId);
        List<Integer> watchedVideoIds = watched.stream().map(UserVideoWatch::getVideoId).collect(Collectors.toList());

        List<Video> allVideos = videoRepository.findAll();

        List<VideoResponseDto> videoResponseDtos = allVideos.stream().map(video -> {
            VideoResponseDto videoDto = new VideoResponseDto(video);
                    if (watchedVideoIds.contains(video.getVideoId())) {
                        videoDto.setWatching(true);
                    }
                    if (bookmark.stream().anyMatch(userVideo -> userVideo.getVideo().getVideoId()== (video.getVideoId()))) {
                        videoDto.setBookmark(true);
                    }
                    return videoDto;
                })
                .collect(Collectors.toList());

        return videoResponseDtos;
    }

}
