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
<form method="post" action="customer">
	<table>
		<tr>
					
			<td><input type = "text" value = "0" name="id" hidden="true"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type = "text" name="name"></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type = "text" name="age"></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type = "text" name="address"></td>
		</tr>
		<tr>
			<td>Permanant Address</td>
			<td><input type = "text" name="perAddress"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type = "text" name="state" value="ENABLED"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="action" value="Add" type="submit"/>
				<input name="action" value="Cancel" type="reset"/>
			</td>
		</tr>
	</table>
</form>
<hr>
<table style="border:solid;">


	<tr>
		<th>id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Address</th>
		<th>Permanant Address</th>
		<th>State</th>
		
	</tr>
	<c:forEach items= "${customer}" var="c">
	<tr>
	    <td>${c.id}</td> 
		<th>${c.name}</th>
		<th>${c.age}</th>
		<th>${c.address}</th>
		<th>${c.perAddress}</th>
		<th>${c.state}</th>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>