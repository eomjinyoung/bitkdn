package com.kdn.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello implements Servlet {
  @Override
  public void destroy() {
    System.out.println("destroy()...");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    System.out.println("init()...");
    
  }

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("service()...");
    
  }

}
