package com.example.saessak.dto;

import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.Work;
import com.example.saessak.entity.WorkResume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResumeResponseDto {

    private int workResumeId;

    private int workId;

    private int resumeId;

    private String state;

    public WorkResumeResponseDto(WorkResume workResume) {
        this.workResumeId = workResume.getWorkResumeId();
        this.workId = workResume.getWork().getWorkId();
        this.resumeId = workResume.getResume().getResumeId();
        this.state = workResume.getState();
    }

}
