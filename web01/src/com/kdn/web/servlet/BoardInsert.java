package com.kdn.web.servlet;

import java.io.IOException;

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
    
    System.out.println(title);
    System.out.println(content);
    
  }

}










