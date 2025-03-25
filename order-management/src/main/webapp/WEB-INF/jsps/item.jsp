<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="item">
	<table>
		<tr>
			
			<td><input type = "text" value = "0" name="id" hidden="true"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type = "text" name="name"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type = "text" name="disc"></td>
		</tr>
				<tr>
			<td>Current Qty</td>
			<td><input type = "text" name="currentQty"></td>
		</tr>
				<tr>
			<td>Reorder Qty</td>
			<td><input type = "text" name="reOrderQty"></td>
		</tr>
				<tr>
			<td>Max Qty</td>
			<td><input type = "text" name="maxQty"></td>
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
		<th>Description</th>
		<th>Current Quant</th>
		<th>Re-order Quant</th>
		<th>Max Quantity</th>
	</tr>
	<c:forEach items="${item}" var="i">
	<tr>
	    <td>${i.id}</td> 
		<th>${i.name}</th>
		<th>${i.disc}</th>
		<th>${i.currentQty}</th>
		<th>${i.reOrderQty}</th>
		<th>${i.maxQty}</th>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>