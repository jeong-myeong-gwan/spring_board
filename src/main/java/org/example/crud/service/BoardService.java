package org.example.crud.service;

import org.example.crud.model.Board;
import org.example.crud.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시글 목록 가져오기
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // 게시글 작성하기
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 삭제하기
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    // 게시글 내용 보기
    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시글을 저장하는 메서드
    public void saveBoard(Board board) {
        boardRepository.save(board);  // Board 객체를 저장
    }
}
