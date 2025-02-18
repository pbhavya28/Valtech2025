<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="depts" method="post">
<table>
	<tr>
		<td>Id</td>
		<td><input type="text" name="eid" value="${dep.id}" ${readonly}/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="ename" value="${dep.name}"/></td>
	</tr>
	<tr>
		<td>Location</td>
		<td><input type="text" name="elocation" value="${dep.location}"/></td>
	</tr>
	
	<tr>
		<td colspan="2">
		<input type="submit" name="operationEdit" value='${mode}'/>
		<input type="submit" name="operationEdit" value="Cancel"/>
		
		</td>
	</tr>
</table>
</form>
</body>
</html>