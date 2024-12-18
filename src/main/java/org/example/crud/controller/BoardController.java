package org.example.crud.controller;

import org.example.crud.model.Board;
import org.example.crud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 목록
    @GetMapping("/list")
    public String getAllBoards(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "list";
    }

    // 게시글 작성 폼
    @GetMapping("/write")
    public String showWriteForm() {
        return "form";
    }

    // 게시글 저장
    @PostMapping("/write")
    public String createBoard(@ModelAttribute Board board) {
        boardService.saveBoard(board);
        return "redirect:/board/list";
    }

    // 게시글 상세 보기
    @GetMapping("/detail/{id}")
    public String getBoardDetail(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return "redirect:/board/list";
        }
        model.addAttribute("board", board);
        return "detail";
    }

    // 게시글 삭제
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }

    @PostMapping("/saveBoard")
    public String saveBoard(@RequestParam String title, @RequestParam String content, @RequestParam String writer) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        boardService.saveBoard(board);  // BoardService를 통해 저장

        return "redirect:/boardList";  // 저장 후 게시판 목록 페이지로 리다이렉트
    }
}
