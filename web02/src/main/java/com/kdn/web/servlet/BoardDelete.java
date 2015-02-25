package com.kdn.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdn.web.dao.BoardDao;

@WebServlet("/board/delete")
public class BoardDelete extends HttpServlet {
  /* 리다이렉트 적용 버전*/
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.delete(no);
      
      //Redirect: 웹 브라우저에게 콘텐츠를 보내지 않는다.
      response.sendRedirect("list");
    } catch (Exception e) {
      e.printStackTrace();
    } 

  }
  
  /* 리다이렉트 적용 전 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String no = request.getParameter("no");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 삭제</title></head><body>");
    out.println("<h1>게시물 삭제</h1>");
    
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/kdndb",
          "kdn",
          "123456789");
      stmt = con.createStatement();
      if (stmt.executeUpdate("delete from boards where bno=" + no) > 0) {
        out.println("<p>게시물을 삭제하였습니다.</p>");
      } else {
        out.println("<p>지정된 게시물을 찾을 수 없습니다.</p>");
      }
      
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  */
}
