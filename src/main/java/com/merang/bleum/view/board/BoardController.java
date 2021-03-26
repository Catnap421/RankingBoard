package com.merang.bleum.view.board;

import com.merang.bleum.biz.board.BoardDAO;
import com.merang.bleum.biz.board.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

//    @PostMapping("/insertBoard")
//    public String insertBoard(BoardDTO boardDTO, BoardDAO boardDAO){
//        boardDAO.insertBoard(boardDTO);
//        return "getBoardList";
//    }
//
//    @PostMapping("/updateBoard")
//    public String updateBoard(BoardDTO boardDTO, BoardDAO boardDAO){
//        boardDAO.updateBoard(boardDTO);
//        return "getBoardList";
//    }
//
//    @PostMapping("/deleteBoard")
//    public String deleteBoard(BoardDTO boardDTO, BoardDAO boardDAO){
//        boardDAO.deleteBoard(boardDTO);
//        return "getBoardList";
//    }
//
//    @GetMapping("/getBoard")
//    public String getBoard(BoardDTO boardDTO, BoardDAO boardDAO, Model model){
//        model.addAttribute("board", boardDAO.getBoard(boardDTO));
//        return "getBoard";
//    }
//
//    @GetMapping("/getBoardList")
//    public String getBoardList(BoardDTO boardDTO, BoardDAO boardDAO, Model model){
//        model.addAttribute("boardList", boardDAO.getBoardList(boardDTO));
//        return "getBoardList";
//    }
}
