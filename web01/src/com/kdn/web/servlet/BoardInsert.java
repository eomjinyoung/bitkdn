package com.kdn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/board/insert")
public class BoardInsert extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //한글이 깨지지 않도록 하려면, getParameter()를 최초로 호출하기 전에 
    //입력 데이터의 인코딩 형식을 설정해야 한다.
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
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

}










