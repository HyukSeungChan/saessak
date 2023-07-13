package com.example.saessak.dto;

import com.example.saessak.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResumeRequestDto {

    private int workResumeId;
    private int workId;
    private int resumeId;
    private String state;

    public WorkResume toEntity() {
        Work work = Work.builder().workId(workId).build();
        Resume resume = Resume.builder().resumeId(resumeId).build();

        return WorkResume.builder()
                .work(work)
                .resume(resume)
                .state(state)
                .build();
    }

}
