package com.kdn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdn.web.dao.BoardDao;
import com.kdn.web.vo.Board;

@WebServlet("/board/list")
public class BoardList extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물목록</title></head><body>");
    out.println("<h1>게시물 목록</h1>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("<th>번호</th>");
    out.println("<th>제목</th>");
    out.println("<th>등록일</th>");
    out.println("<th>조회수</th>");
    out.println("</tr>");
    
    
    try {
      BoardDao boardDao = new BoardDao();
      List<Board> list = boardDao.list();
      
      for(Board board : list) { //DBMS 서버에서 레코드를 하나 가져온다.
        out.println("<tr>");
        out.println("<td>" + board.getNo() + "</td>");
        out.println("<td><a href='detail?no=" 
            + board.getNo() + "'>" 
            + board.getTitle() 
            + "</a></td>");
        out.println("<td>" + board.getCreateDate() + "</td>");
        out.println("<td>" + board.getViewCount() + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<p><a href='form.html'>[새 글]</a></p>");
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
