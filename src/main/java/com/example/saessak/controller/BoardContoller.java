package com.example.saessak.controller;

import com.example.saessak.dto.*;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardContoller {

    private final BoardService boardService;

    private final AmazonS3Service amazonS3Service;

    // 글 생성
    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BoardRequestDto> save(@RequestPart("boardRequestDto") BoardRequestDto boardRequestDto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            boardService.save(boardRequestDto, amazonS3Service.upload(multipartFile).toString());
        } else {
            boardService.save(boardRequestDto);
        }
        return ResponseEntity.ok(boardRequestDto);
    }

    // 농촌 이야기 게시글 리스트 조회
    @GetMapping("/board/story")
    public ResponseEntity<ApiResponse> findAllByAgricultureIsNull() {
        System.out.println("농촌 이야기 게시글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByAgricultureIsNull();
//            return ResponseEntity.ok(user);
            System.out.println("find board story !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board story successfully", board));
        } catch (IllegalArgumentException e) {
            System.out.println("not board story !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board story", null));
        }
    }

    // 도와줘요 게시글 리스트 조회
    @GetMapping("/board/help")
    public ResponseEntity<ApiResponse> findAllByAgricultureIsNotNull() {
        System.out.println("도와줘요 게시글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByAgricultureIsNotNull();
//            return ResponseEntity.ok(user);
            System.out.println("find board help !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board help successfully", board));
        } catch (IllegalArgumentException e) {
            System.out.println("not board help !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board help", null));
        }
    }

    // 해당 글 조회
    @GetMapping("/board/detail")
    public ResponseEntity<ApiResponse> findByBoardId(@RequestParam("boardId") int boardId){
        System.out.println("해당 글 조회 !!");
        try {
            ResponseEntity.notFound();
            BoardResponseDto board = boardService.findByBoardId(boardId);
//            return ResponseEntity.ok(user);
            System.out.println("find board info!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board info successfully", board));
        } catch (IllegalArgumentException e) {
            System.out.println("not board info!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board info", null));
        }
    }

    // 게시글 좋아요 누르기
    @PostMapping("/board/like")
    public ResponseEntity<Boolean> likeBoard(@RequestBody BoardLikeRequestDto boardLikeRequestDto) {
        return ResponseEntity.ok(boardService.likeBoard(boardLikeRequestDto));
    }

    // 게시글 좋아요 내리기
    @PostMapping("/board/unlike")
    public ResponseEntity<Boolean> unlikeBoard(@RequestBody BoardLikeRequestDto boardLikeRequestDto) {
        return ResponseEntity.ok(boardService.unlikeBoard(boardLikeRequestDto));
    }

    // 실시간 인기글
    @GetMapping("/board/hot")
    public ResponseEntity<ApiResponse> findAllByOrderByLikesDesc() {
        System.out.println("실시간 인기글 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByOrderByLikesDesc();
//            return ResponseEntity.ok(user);
            System.out.println("find board hot !!");
//            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board hot successfully", board));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(board);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("NotFound","cant found get board hot", mapper.writeValueAsString(board)));
        } catch (IllegalArgumentException | JsonProcessingException e) {
            System.out.println("not board hot !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board hot", null));
//            return "";
        }
    }

}
