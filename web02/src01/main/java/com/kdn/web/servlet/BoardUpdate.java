package com.kdn.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import com.kdn.web.dao.BoardDao;
import com.kdn.web.vo.Board;

@WebServlet(urlPatterns="/board/update")
public class BoardUpdate extends GenericServlet {
  /* 리다이렉트 적용 후*/
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //한글이 깨지지 않도록 하려면, getParameter()를 최초로 호출하기 전에 
    //입력 데이터의 인코딩 형식을 설정해야 한다.
    request.setCharacterEncoding("UTF-8");
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle( request.getParameter("title") );
    board.setContent( request.getParameter("content") );
    
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.update(board);
      
      HttpServletResponse response2 = (HttpServletResponse)response;
      response2.sendRedirect("list");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }

  
  /* 리다이렉트 적용 전
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //한글이 깨지지 않도록 하려면, getParameter()를 최초로 호출하기 전에 
    //입력 데이터의 인코딩 형식을 설정해야 한다.
    request.setCharacterEncoding("UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    Connection con = null;
    PreparedStatement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/kdndb",
          "kdn",
          "123456789");
      
      //SQL문을 준비한다.
      //값이 들어갈 자리를 ?(in-parameter)로 지정한다.
      stmt = con.prepareStatement(
          "update boards set title=?, content=?, create_date=now() where bno=?");
      
      //준비된 SQL문 값 넣기
      stmt.setString(1, title);
      stmt.setString(2, content);
      stmt.setInt(3, no);
      
      stmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
    //한글을 출력하기
    //- 출력 스트림을 얻기 전에, 전송할 데이터의 형식과 문자집합을 설정한다.
    response.setContentType("text/html;charset=UTF-8");
    
    // 웹 브라우저로 출력하기
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>등록결과</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>등록 성공입니다!</h1>");
    out.println("</body>");
    out.println("</html>");
  }
  */
}










