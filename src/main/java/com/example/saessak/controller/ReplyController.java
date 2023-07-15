package com.example.saessak.controller;

import com.example.saessak.dto.BoardResponseDto;
import com.example.saessak.dto.ReplyRequestDto;
import com.example.saessak.dto.ReplyResponseDto;
import com.example.saessak.dto.ResumeRequestDto;
import com.example.saessak.entity.Reply;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 생성
    @PostMapping("/reply")
    public ResponseEntity<ReplyRequestDto> save(@RequestBody ReplyRequestDto replyRequestDto){
        replyService.save(replyRequestDto);
        return ResponseEntity.ok(replyRequestDto);
    }

    // 해당 글의 댓글 리스트 조회
    @GetMapping("/reply")
    public ResponseEntity<ApiResponse> findAllByBoardBoardId(@RequestParam("boardId") int boardId) {
        System.out.println("해당 글의 댓글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<ReplyResponseDto> reply = replyService.findAllByBoardBoardId(boardId);
//            return ResponseEntity.ok(user);
            System.out.println("find reply !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get reply successfully", reply));
        } catch (IllegalArgumentException e) {
            System.out.println("not reply !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get reply", null));
        }
    }
}
