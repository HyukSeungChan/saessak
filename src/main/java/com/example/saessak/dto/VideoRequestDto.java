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

    private String title;

    private String source;

    private String link;

    private String type;

    private String crops;

    private String crops_name;

    public Video toEntity() {
        return Video.builder()
                .title(title)
                .source(source)
                .link(link)
                .type(type)
                .crops(crops)
                .crops_name(crops_name)
                .build();
    }
}
