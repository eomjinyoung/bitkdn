package com.kdn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 상세보기</title></head><body>");
    out.println("<h1>게시물 상세정보</h1>");
    
    try {
      BoardDao boardDao = new BoardDao();
      Board board = boardDao.detail(no);
      
      if(board != null) { 
        out.println("<form action='update' method='post'>");
        out.println("<table border='1'>");
        
        out.println("<tr>");
        out.println("<th>번호</th>");
        out.println("<td><input type='text' name='no' readonly value='" 
            + board.getNo() + "'></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<th>제목</th>");
        out.println("<td><input type='text' name='title' size='50' value='" 
            + board.getTitle() + "'></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<th>내용</th>");
        out.println("<td><textarea name='content' rows='10' cols='60'>" 
            + board.getContent() + "</textarea></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<th>등록일</th>");
        out.println("<td>" + board.getCreateDate() + "</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<th>조회수</th>");
        out.println("<td>" + board.getViewCount() + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<button>변경</button>");
        out.println("<button type='button' onclick='deleteBoard();'>삭제</button>");
        out.println("</form>");
        
        out.println("<script>");
        out.println("  function deleteBoard() {");
        out.println("    location.href='delete?no=" + board.getNo() + "';");
        out.println("  }");
        out.println("</script>");
        
      } else {
        out.println("<p>지정된 번호의 게시물이 없습니다!</p>");
      }
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } 

  }
}
