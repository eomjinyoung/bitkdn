<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test03 - Expression Element</title>
</head>
<body>
<h1>표현식</h1>
<ol>
  <li>자바 출력문을 삽입할 때 사용.</li>
  <li>표현식 태그의 내용을 파라미터로 사용하여 출력문을 만든다.</li>
  <li>&lt;%=출력할 값%> ==> out.print(출력할 값);</li>
</ol>
<%
String name = "홍길동"; 
%>
<p><%=name%></p>
</body>
</html>
































