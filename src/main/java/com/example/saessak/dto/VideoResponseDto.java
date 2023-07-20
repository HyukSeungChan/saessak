package com.example.saessak.dto;

import com.example.saessak.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoResponseDto {

    private int videoId;

    private String title;

    private String source;

    private String link;

    private String type;

    private String thumbnail;

    private String crops;

    private String cropsName;

    private boolean watching;

    private boolean bookmark;

    public VideoResponseDto(Video video) {
        this.videoId = video.getVideoId();
        this.title = video.getTitle();
        this.source = video.getSource();
        this.link = video.getLink();
        this.type = video.getType();
        this.crops = video.getCrops();
        this.cropsName = video.getCropsName();
        this.thumbnail = video.getThimbnail();
    }
}
