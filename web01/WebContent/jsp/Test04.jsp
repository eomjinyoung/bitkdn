<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test04 - Declaration Element</title>
</head>
<body>
<h1>JSP 선언문</h1>
<ol>
  <li>클래스 멤버(변수와 메서드)를 선언할 때 사용.</li>
  <li>클래스 블록에 그대로 복사됨.</li>
  <li>어차파 클래스 블록에 복사되기 때문에, 엘리먼트를 선언하는 위치는 상관없다.</li>
</ol>
<p><%=name%></p>
<p><%=plus(10, 20)%></p>
</body>
</html>

<%!
String name = "홍길동";

int plus(int a, int b) {
  return a + b;
}
%>































