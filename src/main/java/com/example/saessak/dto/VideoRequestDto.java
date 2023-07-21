package com.example.saessak.dto;

import com.example.saessak.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoRequestDto {

    private int videoId;

    private String title;

    private String source;

    private String link;

    private String type;

    private String thumbnail;

    private String crops;

    private String crops_name;

    public Video toEntity() {
        return Video.builder()
                .videoId(videoId)
                .title(title)
                .source(source)
                .link(link)
                .type(type)
                .crops(crops)
                .thimbnail(thumbnail)
                .cropsName(crops_name)
                .build();
    }
}
