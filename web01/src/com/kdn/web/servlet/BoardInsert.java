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
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("okok");
    
  }

}










