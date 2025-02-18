<%@ page language="java"
	import = "dao.Employee"
	import = "java.util.List"
	 contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters = ${counters}
Current department = ${current} 
<form action="depts" method="post">
<table>
	<tr>
		<td>Id</td>
		<td>${dept.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${dept.name}</td>
	</tr>
	<tr>
		<td>Location</td>
		<td>${dept.location}</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" name="operation" value="First"/>
			<input type="submit" name="operation" value="Previous"/>
			<input type="submit" name="operation" value="Next"/>
			<input type="submit" name="operation" value="Last"/>
			<input type="submit" name="operation" value="Update"/>
			<input type="submit" name="operation" value="Delete"/>
			<input type="submit" name="operation" value="New"/>
			
			
			
		</td>

	</tr>
</table>
<h2> Employees in ${dept.name} department</h2>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Salary</th>
		<th>Experience</th>
		<th>Level</th>
		<th>DeptId</th>	
	</tr>
	 <% 
	
	List<Employee> empByDept = (List<Employee>)session.getAttribute("empByDept");

	for(Employee e: empByDept){
	
	%>
	<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName() %></td>
		<td><%=e.getAge() %></td>
		<td><%=e.getGender() %></td>
		<td><%=e.getSalary() %></td>
		<td><%=e.getExperience() %></td>
		<td><%=e.getLevel() %></td>
		<td><%=e.getDeptId() %></td>
		
	</tr>
	
	<%} %> 

</table>
</form>
</body>
</html>