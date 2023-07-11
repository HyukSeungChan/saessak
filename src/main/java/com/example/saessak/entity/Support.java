package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_id")
    // 지원정책ID
    private int supportId;

    @Column(name = "name")
    // 지원사업명
    private String name;

    @Column(name = "target")
    // 지원대상
    private String target;

    @Column(name = "content")
    // 지원내용
    private String content;

    @Column(name = "condition")
    // 지원조건
    private String condition;

    @Column(name = "inquiry")
    // 문의
    private String inquiry;

    @Column(name = "period")
    // 지원기간
    private int period;

    @Column(name = "organization")
    // 댓글 수
    private int organization;

    @Column(name = "crops")
    // 주체기관
    private String crops;

    @Column(name = "type")
    // 주체기관
    private String type;

    @OneToMany(mappedBy = "support")
    // mapping
    private List<UserSupport> userSupports = new ArrayList<>();

}
