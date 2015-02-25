package com.kdn.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdn.web.dao.BoardDao;
import com.kdn.web.vo.Board;

@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    response.setContentType("text/html;charset=UTF-8");
    try {
      BoardDao boardDao = new BoardDao();
      Board board = boardDao.detail(no);
      
      request.setAttribute("board", board);
      
      RequestDispatcher rd = request.getRequestDispatcher("/board/Detail.jsp");
      rd.include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
