package com.kdn.web.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdn.web.dao.BoardDao;
import com.kdn.web.vo.Board;

//클라이언트 요청을 처리하는 페이지 컨트롤러
@Controller
public class BoardControl {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/board/insert")
  public String insert(Board board) {
    boardDao.insert(board);
    return "redirect:list.do";
  }
  
  @RequestMapping("/board/list")
  public ModelAndView list() {
    List<Board> list = boardDao.list();
    ModelAndView mv = new ModelAndView();
    mv.setViewName("board/List");
    mv.addObject("list", list);
    
    return mv;
  }
  
  @RequestMapping("/board/detail")
  public String detail(int no, Model model) {
    Board board = boardDao.detail(no);
    model.addAttribute("board", board);
    return "board/Detail";
  }
  
  @RequestMapping("/board/update")
  public String update(Board board) {
    boardDao.update(board);
    return "redirect:list.do";
  }  
  
  @RequestMapping("/board/delete")
  public String delete(int no) {
    boardDao.delete(no);
    return "redirect:list.do";
  }
}










