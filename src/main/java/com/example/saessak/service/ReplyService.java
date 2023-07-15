package com.example.saessak.service;

import com.example.saessak.dto.BoardResponseDto;
import com.example.saessak.dto.ReplyRequestDto;
import com.example.saessak.dto.ReplyResponseDto;
import com.example.saessak.dto.ResumeRequestDto;
import com.example.saessak.entity.Board;
import com.example.saessak.entity.Reply;
import com.example.saessak.entity.Resume;
import com.example.saessak.entity.UserReply;
import com.example.saessak.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final WorkerRepository workerRepository;

    private final FarmRepository farmRepository;

    private final BoardRepository boardRepository;

    private final UserReplyRepository userReplyRepository;


    // 댓글 생성
    @Transactional
    public Reply save(ReplyRequestDto replyRequestDto){
        System.out.println("------ 댓글 생성 ------");
        Reply reply = replyRepository.save(replyRequestDto.toEntity(workerRepository, farmRepository));
        int boardId = replyRequestDto.getBoardId();
        Board board = boardRepository.findByBoardId(boardId);
        board.setReplies(board.getReplies()+1);
        // 내가 쓴 댓글 로직 추가
        return reply;
    }

    // 해당 글의 댓글 리스트 조회
    @Transactional(readOnly = true)
    public List<ReplyResponseDto> findAllByBoardBoardId(int boardId) {
        System.out.println("------ 해당 글의 댓글 리스트 ------");
        List<Reply> entity = replyRepository.findAllByBoardBoardId(boardId);
        return entity.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }
}
