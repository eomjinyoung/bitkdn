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
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    System.out.println(title);
    System.out.println(content);
    
  }

}










