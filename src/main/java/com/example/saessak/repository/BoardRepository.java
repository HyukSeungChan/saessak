package com.example.saessak.repository;

import com.example.saessak.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 농촌 이야기 게시글 리스트 조회
    List<Board> findAllByAgricultureIsNull();

    // 도와줘요 게시글 리스트 조회
    List<Board> findAllByAgricultureIsNotNull();

    // 해당 게시글 조회
    Board findByBoardId(int boardId);

    // 좋아요 수 증가
    @Modifying
    @Query("UPDATE Board b SET b.likes = b.likes + 1 WHERE b.boardId = :boardId")
    void increaseLikes(@Param("boardId") int boardId);

    // 좋아요 수 감소
    @Modifying
    @Query("UPDATE Board b SET b.likes = b.likes - 1 WHERE b.boardId = :boardId")
    void decreaseLikes(@Param("boardId") int boardId);

    // 실시간 인기글
    List<Board> findAllByOrderByRepliesDesc();

    // 도와줘요 필터링
    List<Board> findAllByAgricultureIsNotNullAndCropsContaining(String crops);

    // 내가 쓴 글
    List<Board> findAllByUserUserId(Long userId);
}
