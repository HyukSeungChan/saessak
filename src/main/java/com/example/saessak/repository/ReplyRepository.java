package com.example.saessak.repository;

import com.example.saessak.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    // 해당 글의 댓글 리스트 조회
    List<Reply> findAllByBoardBoardId(int boardId);

    // 내가 쓴 댓글 리스트 조회
    List<Reply> findAllByUserUserId(Long userId);
}
