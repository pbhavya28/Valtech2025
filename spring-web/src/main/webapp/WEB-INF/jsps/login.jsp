<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="login">
	<table>
		<tr>
			<td>Username</td>
			<td><input type = "text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type = "password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="action" value="Login" type="submit"/>
				<input name="action" value="Cancel" type="submit"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>