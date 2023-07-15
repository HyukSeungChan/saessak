package com.example.saessak.service;

import com.example.saessak.dto.*;
import com.example.saessak.entity.Board;
import com.example.saessak.entity.Farm;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.UserWork;
import com.example.saessak.repository.BoardRepository;
import com.example.saessak.repository.FarmRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final WorkerRepository workerRepository;

    private final FarmRepository farmRepository;

    // 글 생성 사진 있을 때
    @Transactional
    public Board save(BoardRequestDto boardRequestDto, String fileUrl){
        System.out.println("------ 글 생성 ------");
        if (fileUrl != null) {
            fileUrl = fileUrl.replace("[", "").replace("]", "");
        }
        boardRequestDto.setImage(fileUrl);
        boardRequestDto.setLikes(0);
        boardRequestDto.setReplies(0);
        return boardRepository.save(boardRequestDto.toEntity(workerRepository, farmRepository));
    }

    // 글 생성 사진 없을 때
    @Transactional
    public Board save(BoardRequestDto boardRequestDto){
        System.out.println("------ 글 생성 ------");
        boardRequestDto.setLikes(0);
        boardRequestDto.setReplies(0);
        return boardRepository.save(boardRequestDto.toEntity(workerRepository, farmRepository));
    }

    // 농촌 이야기 게시글 리스트 조회
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByAgricultureIsNull() {
        System.out.println("------ 농촌 이야기 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAllByAgricultureIsNull();
        return entity.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 도와줘요 게시글 리스트 조회
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByAgricultureIsNotNull() {
        System.out.println("------ 농촌 이야기 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAllByAgricultureIsNotNull();
        return entity.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 해당 글 조회
    @Transactional(readOnly = true)
    public BoardResponseDto findByBoardId(int boardId){
        System.out.println("------ 해당 글 조회 ------");
        Board entity = boardRepository.findByBoardId(boardId);
        return new BoardResponseDto(entity);
    }

    // 게시글 좋아요 누르기
    @Transactional
    public Boolean likeBoard(BoardLikeRequestDto requestDto) {
        System.out.println("------ 게시글 좋아요 누르기 ------");
        int boardId = requestDto.getBoardId();
        Board board = boardRepository.findByBoardId(boardId);
        boardRepository.increaseLikes(boardId);

        return true;
    }

    // 게시글 좋아요 내리기
    @Transactional
    public Boolean unlikeBoard(BoardLikeRequestDto requestDto) {
        System.out.println("------ 게시글 좋아요 내리기 ------");
        int boardId = requestDto.getBoardId();
        Board board = boardRepository.findByBoardId(boardId);
        boardRepository.decreaseLikes(boardId);

        return true;
    }

    // 실시간 인기글
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByOrderByLikesDesc() {
        System.out.println("------ 실시간 인기글 ------");
        List<Board> entity = boardRepository.findAllByOrderByLikesDesc();
        return entity.stream().limit(2).map(BoardResponseDto::new).collect(Collectors.toList());
    }
}
