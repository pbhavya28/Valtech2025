<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="login">
		<table>
			<tr>
				<td>Username</td>
				<td><input name = "username" type="text"></td>
				
			</tr>
			<tr>
				<td>Password</td>
				<td><input name = "password" type="text"></td>
			</tr>
			<tr>
				<td colspan = "2">
				<input type="submit" value="login" name="login"/>
				</td>
			</tr>
			
			
		
		</table>
	
	</form>

</body>
</html>