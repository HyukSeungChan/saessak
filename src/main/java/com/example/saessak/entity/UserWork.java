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
public class UserWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_work_id")
    // 유저-일자리ID
    private int userWorkId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // 유저ID
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id")
    // 일자리ID
    private Work work;
}
