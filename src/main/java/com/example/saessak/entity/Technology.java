package com.example.saessak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    // 이달의농업기술ID
    private int technologyId;

    @Column(name = "name")
    // 이달의농업기술명
    private String name;

    @Column(name = "date")
    // 날짜
    private String date;

    @Column(name = "content")
    // 내용
    private String content;

    @Column(name = "image")
    // 사진
    private String image;
}
