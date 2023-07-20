package com.example.saessak.controller;

import com.example.saessak.dto.*;
import com.example.saessak.entity.Board;
import com.example.saessak.payload.ApiResponse;
import com.example.saessak.service.AmazonS3Service;
import com.example.saessak.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardContoller {

    private final BoardService boardService;

    private final AmazonS3Service amazonS3Service;

    // 글 생성
    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BoardRequestDto> save(@RequestPart("boardRequestDto") BoardRequestDto boardRequestDto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) throws IOException {
        boardService.save(boardRequestDto, amazonS3Service.upload(multipartFile));
        return ResponseEntity.ok(boardRequestDto);
    }

    // 글 전체 받아오기
    @GetMapping("/board/all")
    public ResponseEntity<ApiResponse> findAll() {
        System.out.println("게시글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAll();
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find board story !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board story successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
            System.out.println("not board story !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board story", null));
        }
    }

    // 농촌 이야기 게시글 리스트 조회
    @GetMapping("/board/story")
    public ResponseEntity<ApiResponse> findAllByAgricultureIsNull() {
        System.out.println("농촌 이야기 게시글 리스트 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByAgricultureIsNull();
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find board story !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board story successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
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
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find board help !!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board help successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
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
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find board info!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board info successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
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
    public ResponseEntity<ApiResponse> findAllByOrderByRepliesDesc() {
        System.out.println("실시간 인기글 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByOrderByRepliesDesc();
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

    // 도와줘요 필터링
    @GetMapping("board/help/crops")
    public ResponseEntity<ApiResponse> findAllByAgricultureIsNotNullAndCropsContaining(@RequestParam("crops") String crops) {
        System.out.println("도와줘요 필터링 조회 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByAgricultureIsNotNullAndCropsContaining(crops);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find board filter!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get board filter successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
            System.out.println("not board filter!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get board filter", null));
        }
    }

    // 내가 쓴 글 확인
    @GetMapping("/board/my")
    public ResponseEntity<ApiResponse> findAllByUserUserId(@RequestParam("userId") Long userId) {
        System.out.println("내가 쓴 글 확인 !!");
        try {
            ResponseEntity.notFound();
            List<BoardResponseDto> board = boardService.findAllByUserUserId(userId);
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.ok(user);
            System.out.println("find my board!!");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created","get my board successfully", mapper.writeValueAsString(board)));
        } catch (Exception e) {
            System.out.println("not my board!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound","cant found get my board", null));
        }
    }

}
