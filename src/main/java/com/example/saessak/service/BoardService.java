package com.example.saessak.service;

import com.example.saessak.dto.*;
import com.example.saessak.entity.Board;
import com.example.saessak.repository.BoardRepository;
import com.example.saessak.repository.FarmRepository;
import com.example.saessak.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final WorkerRepository workerRepository;

    private final FarmRepository farmRepository;

    // 글 생성
    @Transactional
    public Board save(BoardRequestDto boardRequestDto, String fileUrl){
        System.out.println("------ 글 생성 ------");
        if (fileUrl != null) {
            fileUrl = fileUrl.replace("[", "").replace("]", "");
        } else {
            fileUrl = null;
        }
        boardRequestDto.setImage(fileUrl);
        boardRequestDto.setLikes(0);
        boardRequestDto.setReplies(0);
        return boardRepository.save(boardRequestDto.toEntity(workerRepository, farmRepository));
    }

    // 글 전체 받아오기
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        System.out.println("------ 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAll();
        return entity.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 농촌 이야기 게시글 리스트 조회
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByAgricultureIsNull() {
        System.out.println("------ 농촌 이야기 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAll();
        List<Board> list = new ArrayList<>();
        for (Board board : entity) {
            if (board.getAgriculture().length() == 0) {
                System.out.println("size"+ list.size());
                list.add(board);
            }else{
                System.out.println("length" + board.getAgriculture().length());
            }
        }
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 도와줘요 게시글 리스트 조회
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByAgricultureIsNotNull() {
        System.out.println("------ 도와줘요 이야기 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAll();
        List<Board> list = new ArrayList<>();
        for (Board board : entity) {
            if (board.getAgriculture().length() != 0) {
                list.add(board);
            }
        }
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
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
    public List<BoardResponseDto> findAllByOrderByRepliesDesc() {
        System.out.println("------ 실시간 인기글 ------");
        List<Board> entity = boardRepository.findAllByOrderByRepliesDesc();
        return entity.stream().limit(2).map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 도와줘요 필터링
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByAgricultureIsNotNullAndCropsContaining(String crops) {
        System.out.println("------ 실시간 인기글 ------");
        List<Board> entity;
        List<Board> board = new ArrayList<>();
        if(crops.equals("전체")){
            entity = boardRepository.findAll();
            for (Board boards : entity) {
                if (boards.getAgriculture().length() != 0) {
                    board.add(boards);
                }
            }
        }else{
            entity = boardRepository.findAll();
            for (Board boards : entity) {
                if (boards.getAgriculture().length() != 0 && boards.getAgriculture().equals(crops)) {
                    board.add(boards);
                }
            }
        }
        return board.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 내가 쓴 글 확인
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAllByUserUserId(Long userId) {
        System.out.println("------ 게시글 리스트 조회 ------");
        List<Board> entity = boardRepository.findAllByUserUserId(userId);
        return entity.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

}
