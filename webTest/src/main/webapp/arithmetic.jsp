<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
A = <%= request.getParameter("a") %><br/>
B = <%= request.getParameter("b") %><br/>
Operation = <%= request.getParameter("operation") %><br/>
Result = <%= request.getAttribute("result") %><br/>
Welcome <%= request.getAttribute("username") %>. You are registerd as a <%=request.getAttribute("role") %>
<br/>

	<form method ="post" action = "arithmetic">
	   A = <input type="text" name="a"/><br/>
	   B = <input type="text" name="b"/><br/>
	   <input type="submit" name="operation" value="add"/>
	   <input type="submit" name="operation" value="subtract"/>
	   <input type="submit" name="operation" value="multiply"/>
	   <input type="submit" name="operation" value="division"/>
	   
	   
	</form>
</body>
</html>