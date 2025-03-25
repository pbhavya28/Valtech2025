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

<form method="post" action="placeOrder">
	<table>

		<tr>
			<td>Customer Id: </td>
			<td><input type = "text" name="custId"></td>
		</tr>
		<tr>
			<td>Item: </td>
			<td><input type = "text" name="itemName"></td>
		</tr>
		<tr>
			<td>Quantity: </td>
			<td><input type = "text" name="quantity"></td>
		</tr>
		</br></br>
		<tr>
			<td colspan="2">
				<input name="action" value="Add" type="submit"/>
				<input name="action" value="Cancel" type="reset"/>
			</td>
		</tr>
	</table>
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
</form> 
</body>
</html>